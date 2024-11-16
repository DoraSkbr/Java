package org.dstu;

import org.dstu.components.MyPanel;
import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;
import org.dstu.shapes.animators.PerimeterCircleAnimator;
import org.dstu.shapes.animators.SquareKeyboardAnimator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle c1 = new Circle(500, 400, 50, Color.MAGENTA);
        Circle c2 = new Circle(450, 400, 50, Color.PINK);
        Circle c3 = new Circle(400, 400, 50, Color.ORANGE);
        Circle c4 = new Circle(350, 400, 50, Color.YELLOW);
        Circle c5 = new Circle(300, 400, 50, Color.GREEN);

        Square s = new Square(600, 600, 50, Color.GRAY);

        shapes.add(c1);
        shapes.add(c2);
        shapes.add(c3);
        shapes.add(c4);
        shapes.add(c5);
        shapes.add(s);

        // 1. Создать реализацию Runnable
        // 2. Создать нить (поток) - экземпляр Thread
        // 3. Запустить поток (Thread.start())

        MyPanel canvas = new MyPanel(shapes);
        c1.setAnimator(new PerimeterCircleAnimator(c1, canvas));
        c2.setAnimator(new PerimeterCircleAnimator(c2, canvas));
        c3.setAnimator(new PerimeterCircleAnimator(c3, canvas));
        c4.setAnimator(new PerimeterCircleAnimator(c4, canvas));
        c5.setAnimator(new PerimeterCircleAnimator(c5, canvas));
        
        // SquareKeyboardAnimator как KeyListener
        SquareKeyboardAnimator squareAnimator = new SquareKeyboardAnimator(s);
        canvas.addKeyListener(squareAnimator);
        canvas.setFocusable(true);
        canvas.requestFocusInWindow();

        for (Shape shape: shapes) {
            Thread t = new Thread(shape.getAnimator());
            t.start();
        }

//        Runnable myController = () -> {
//            while (true) {
//                shapes.forEach(shape -> {
//                    if (shape instanceof Circle) {
//                        shape.moveRel((int)(Math.random() * 15), (int)(Math.random() * 10));
//                    } else if (shape instanceof Square) {
//                        shape.moveRel(-(int)(Math.random() * 15), -(int)(Math.random() * 10));
//                    }
//                });
//                canvas.repaint();
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);

//        Thread thread = new Thread(myController);
//        thread.start();

        frame.setVisible(true);
    }
}