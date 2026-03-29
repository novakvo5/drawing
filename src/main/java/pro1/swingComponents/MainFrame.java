package pro1.swingComponents;

import pro1.drawingModel.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    private DisplayPanel displayPanel;

    private int x, y;
    private double scale = 1.0;
    private double rotation = 0.0;

    private boolean redMode = false;

    public MainFrame() {
        setTitle("PRO1 Drawing");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        displayPanel = new DisplayPanel();
        add(displayPanel, java.awt.BorderLayout.CENTER);

        JPanel leftPanel = new OptionsPanel(this);
        add(leftPanel, java.awt.BorderLayout.WEST);

        setVisible(true);

        displayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                x = e.getX();
                y = e.getY();
                showExample();
            }
        });
    }

    public void setScale(double scale) { this.scale = scale; }
    public void setRotation(double rotation) { this.rotation = rotation; }
    public void setRedMode(boolean value) { this.redMode = value; }
    public DisplayPanel getDisplayPanel() { return displayPanel; }

    public void showExample() {
        displayPanel.addDrawable(example());
    }

    private Drawable example() {
        String color = redMode ? "#FF0000" : "#808080";

        Drawable d1 = new Rectangle(10, 70, 150, 100, color);
        Drawable d2 = new Triangle(0, 0, 170, 75, color);

        return new Group(new Drawable[]{d1, d2}, x, y, rotation, scale, scale);
    }

    public void clearAll() { displayPanel.clear(); }
}