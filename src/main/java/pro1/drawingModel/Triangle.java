package pro1.drawingModel;

import java.awt.*;

public class Triangle implements Drawable {
    private int x, y, width, height;
    private String color;
    private double scale = 1.0;

    public Triangle(int x, int y, int width, int height, String color) {
        this.x = x; this.y = y;
        this.width = width; this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        int[] xs = {x, x + (int)(width/2.0*scale), x + (int)(width*scale)};
        int[] ys = {y + (int)(height*scale), y, y + (int)(height*scale)};
        g.setColor(Color.decode(color));
        g.fillPolygon(xs, ys, 3);
    }

    @Override
    public void setColor(String color) { this.color = color; }

    @Override
    public void setScale(double scale) {
    }
}