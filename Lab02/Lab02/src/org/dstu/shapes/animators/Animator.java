package org.dstu.shapes.animators;

import org.dstu.shapes.Shape;

import javax.swing.*;

public abstract class Animator implements Runnable {
    protected Shape shape;
    protected JComponent component;

    public Animator(Shape shape, JComponent component) {
        this.shape = shape;
        this.component = component;
    }
}
