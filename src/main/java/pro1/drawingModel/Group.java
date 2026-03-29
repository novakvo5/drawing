package pro1.drawingModel;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Group implements Drawable {
    private Drawable[] children;
    private double x, y;
    private double rotationDegrees;
    private double scaleX, scaleY;

    public Group(Drawable[] children, double x, double y, double rotationDegrees, double scaleX, double scaleY) {
        this.children = children;
        this.x = x; this.y = y;
        this.rotationDegrees = rotationDegrees;
        this.scaleX = scaleX; this.scaleY = scaleY;
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform old = g.getTransform();
        g.translate(x, y);
        g.rotate(Math.toRadians(rotationDegrees));
        g.scale(scaleX, scaleY);

        for (Drawable d : children) d.draw(g);

        g.setTransform(old);
    }

    @Override
    public void setColor(String color) {
        for (Drawable d : children) d.setColor(color);
    }

    @Override
    public void setScale(double scale) {
        this.scaleX = scale;
        this.scaleY = scale;
    }
}