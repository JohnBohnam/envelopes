package com.example.envelopes;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;

public class Drawer {
    record Point(int x, int y) {

    }
    public int xCenter = 300, yCenter = 300;
    public int radius = 200;
    public Drawer() {
    }

    static Point pointOnCircle(int n, double i, Point center, int radius) {
        double angle = 2*Math.PI*i/n;
        int x = (int) (Math.cos(angle)*radius) + center.x;
        int y = (int) (Math.sin(angle)*radius) + center.y;
        return new Point(x, y);
    }

    public Collection<Node> draw(int n, double t) {
        ArrayList<Node> res = new ArrayList<>();
        Point center = new Point(xCenter, yCenter);
        for (int i=0; i<n; i++) {
            Point A = pointOnCircle(n, i, center, radius);
            Point B = pointOnCircle(n, i*t, center, radius);
            Line line = new Line(A.x, A.y, B.x, B.y);
            res.add(line);
        }
        return res;
    }
}
