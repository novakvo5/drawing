package pro1.swingComponents;

import pro1.drawingModel.Drawable;
import pro1.drawingModel.Group;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel extends JPanel {

    private final List<Drawable> drawables = new ArrayList<>();

    public void addDrawable(Drawable d) {
        drawables.add(d);
        repaint();
    }

    public void clear() {
        drawables.clear();
        repaint();
    }

    public void setAllColor(String color) {
        for (Drawable d : drawables) {
            d.setColor(color);
        }
        repaint();
    }

    public void setAllScale(double scale) {
        for (Drawable d : drawables) {
            if (d instanceof Group) {
                ((Group) d).setScale(scale);
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Drawable d : drawables) {
            d.draw(g2);
        }
    }
}