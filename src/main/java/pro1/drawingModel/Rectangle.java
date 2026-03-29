package pro1.drawingModel;

import java.awt.*;

public class Rectangle implements Drawable {
    private int x, y, width, height;
    private String color;
    private double scale = 1.0;

    public Rectangle(int x, int y, int width, int height, String color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));
        g.fillRect(x, y, (int) (width * scale), (int) (height * scale));
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setScale(double scale) {
    }
}