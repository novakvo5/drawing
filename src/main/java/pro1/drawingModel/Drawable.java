package pro1.drawingModel;

import java.awt.Graphics2D;

public interface Drawable {
    void draw(Graphics2D g);
    void setColor(String color);
    void setScale(double scale);
}