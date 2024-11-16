package org.dstu.shapes.animators;

import org.dstu.shapes.Square;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class SquareKeyboardAnimator  implements KeyListener {
    private Square square;
    private final int STEP = 10;

    public SquareKeyboardAnimator(Square square) {
        this.square = square;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:    //  вверх
                square.setY(square.getY() - STEP);
                break;
            case KeyEvent.VK_DOWN:  // вниз
                square.setY(square.getY() + STEP);
                break;
            case KeyEvent.VK_LEFT:  // влево
                square.setX(square.getX() - STEP);
                break;
            case KeyEvent.VK_RIGHT: // вправо
                square.setX(square.getX() + STEP);
                break;
            case KeyEvent.VK_SPACE: // Пробел для изменения цвета
                changeColor();
                break;
            case KeyEvent.VK_PLUS:  // + для увеличения размера
            case KeyEvent.VK_EQUALS:
                square.setSide(square.getSide() + STEP);
                break;
            case KeyEvent.VK_MINUS: // - для уменьшения размера
                if (square.getSide() > STEP) {
                    square.setSide(square.getSide() - STEP);
                }
                break;
        }
    }

    private void changeColor() {
        Color newColor = new Color(
            (int)(Math.random() * 256),
            (int)(Math.random() * 256),
            (int)(Math.random() * 256)
        );
        square.setColor(newColor);
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}