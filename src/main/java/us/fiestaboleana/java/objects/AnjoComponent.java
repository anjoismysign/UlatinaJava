package us.fiestaboleana.java.objects;

import javax.swing.*;

public class AnjoComponent {
    private JLabel label;
    private JComponent component;

    public AnjoComponent(String label, JComponent component) {
        this.label = new JLabel(label);
        this.component = component;
    }

    public AnjoComponent(JLabel jLabel, JComponent component) {
        this.label = jLabel;
        this.component = component;
    }

    public AnjoComponent(){}

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = new JLabel(label);
    }

    public JComponent getComponent() {
        return component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }
}
