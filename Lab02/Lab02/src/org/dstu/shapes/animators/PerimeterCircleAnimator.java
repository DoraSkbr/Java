package org.dstu.shapes.animators;

import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;
import javax.swing.*;
import java.awt.*;

public class PerimeterCircleAnimator extends Animator {
    private int direction = 0; // 0 - вправо, 1 - вниз, 2 - влево, 3 - вверх
    private final int STEP = 5; // шаг движения
    
    public PerimeterCircleAnimator(Circle shape, JComponent component) {
        super(shape, component);
    }

    private void changeColor() {
        // Генерируем случайный цвет
        Color newColor = new Color(
            (int)(Math.random() * 256),
            (int)(Math.random() * 256),
            (int)(Math.random() * 256)
        );
        ((Circle)shape).setColor(newColor);
    }

    @Override
    public void run() {
        while (true) {
            if (shape != null && component != null) {
                // Получаем текущие координаты
                int x = shape.getX();
                int y = shape.getY();
                
                // Получаем границы компонента
                int maxWidth = component.getWidth() - ((Circle)shape).getRadius() * 2;
                int maxHeight = component.getHeight() - ((Circle)shape).getRadius() * 2;

                // Движение по периметру и смена направления
                switch (direction) {
                    case 0: // движение вправо
                        if (x >= maxWidth) {
                            direction = 1;
                            changeColor();
                        } else {
                            shape.moveRel(STEP, 0);
                        }
                        break;
                    case 1: // движение вниз
                        if (y >= maxHeight) {
                            direction = 2;
                            changeColor();
                        } else {
                            shape.moveRel(0, STEP);
                        }
                        break;
                    case 2: // движение влево
                        if (x <= 0) {
                            direction = 3;
                            changeColor();
                        } else {
                            shape.moveRel(-STEP, 0);
                        }
                        break;
                    case 3: // движение вверх
                        if (y <= 0) {
                            direction = 0;
                            changeColor();
                        } else {
                            shape.moveRel(0, -STEP);
                        }
                        break;
                }

                component.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}