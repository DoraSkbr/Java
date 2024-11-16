package org.dstu.components;

import org.dstu.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyPanel extends JPanel {
    private List<Shape> shapes;

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public MyPanel() {
    }

    public MyPanel(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shapes != null && !shapes.isEmpty()) {
            for (Shape shape: shapes) {
                shape.draw(g);
            }
        }
    }
}
