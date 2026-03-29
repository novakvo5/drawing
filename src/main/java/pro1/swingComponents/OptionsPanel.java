package pro1.swingComponents;

import javax.swing.*;

public class OptionsPanel extends JPanel {
    private final MainFrame parent;
    private JSlider sizeSlider;
    private JSlider rotationSlider;

    public OptionsPanel(MainFrame parent) {
        this.parent = parent;
        this.setPreferredSize(new java.awt.Dimension(200, 0));

        JButton clearBtn = new JButton("Reset");
        this.add(clearBtn);
        clearBtn.addActionListener(e -> parent.clearAll());

        sizeSlider = new JSlider(50, 200, 125);
        add(sizeSlider);

        rotationSlider = new JSlider(0, 360, 0);
        add(rotationSlider);

        JCheckBox colorCheck = new JCheckBox("Barevnost");
        add(colorCheck);
        colorCheck.addActionListener(e -> {
            boolean selected = colorCheck.isSelected();
            parent.setRedMode(selected);

            String color = selected ? "#FF0000" : "#808080";
            parent.getDisplayPanel().setAllColor(color);
        });

        sizeSlider.addChangeListener(e -> {
            double scale = sizeSlider.getValue() / 100.0;

            parent.getDisplayPanel().setAllScale(scale);

            parent.setScale(scale);
        });
        rotationSlider.addChangeListener(e -> updateValues());
    }

    private void updateValues() {
        double scale = sizeSlider.getValue() / 100.0;
        double rotation = rotationSlider.getValue();
        parent.setScale(scale);
        parent.setRotation(rotation);
    }
}