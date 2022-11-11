package us.fiestaboleana.java.swing;

import us.fiestaboleana.java.objects.DoubleResult;
import us.fiestaboleana.java.objects.IntegerResult;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * @author anjoismysign
 */
public class AnjoPane {
    private JPanel panel;
    private int result;

    /**
     * default constructor
     *
     * @param panel the panel
     */
    public AnjoPane(JPanel panel) {
        this.panel = panel;
    }

    /**
     * empty constructor. you need to call {@link #setPanel(JPanel)} to set the panel
     */
    public AnjoPane() {
    }

    /**
     * @param components Los componentes que conforman el panel
     * @param title      Título del panel
     * @param optionType Tipo de botones que se mostrarán
     *                   0 = YES_NO_OPTION.
     *                   1 = YES_NO_CANCEL_OPTION.
     *                   2 = OK_CANCEL_OPTION.
     *                   -1 = DEFAULT_OPTION.
     * @param image      Imagen que se usará como ícono en el programa
     * @return El panel
     * @see AnjoComponent
     */
    public static AnjoPane build(Collection<AnjoComponent> components,
                                 String title, int optionType,
                                 Image image) {
        AnjoPane pane = new AnjoPane(new JPanel(new GridLayout(components.size(), 2)));
        JPanel panel = pane.getPanel();
        components.forEach(component -> {
            panel.add(component.getLabel());
            panel.add(component.getComponent());
        });
        if (image != null) {
            JPanel master = new JPanel(new BorderLayout());
            JPanel imagePanel = new JPanel(new FlowLayout());
            JLabel label = new JLabel(new ImageIcon(image));
            imagePanel.add(label);
            master.add(imagePanel, BorderLayout.CENTER);
            master.add(panel, BorderLayout.PAGE_END);
            pane.setResult(new AnjoConfirmDialog(master, title, optionType, image).getResult());
            return pane;
        }
        pane.setResult(new AnjoConfirmDialog(panel, title, optionType, null).getResult());
        return pane;
    }

    /**
     * construye el panel pero sin imagen
     *
     * @param components Los componentes que conforman el panel
     * @param title      Título del panel
     * @param optionType Tipo de botones que se mostrarán
     *                   0 = YES_NO_OPTION.
     *                   1 = YES_NO_CANCEL_OPTION.
     *                   2 = OK_CANCEL_OPTION.
     *                   -1 = DEFAULT_OPTION, que es lo mismo que solamente YES/OK/CONTINUE
     * @return El panel
     * @see AnjoComponent
     */
    public static AnjoPane build(Collection<AnjoComponent> components,
                                 String title, int optionType) {
        return build(components, title, optionType, null);
    }

    /**
     * sets the panel
     *
     * @param panel the panel
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * sets the result
     *
     * @param result the result
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return 0 en caso de "YES/OK", 1 en caso de "NO", 2 en caso de "CANCEL", -1 en caso de
     * haber cerrado la ventana
     */
    public int getResult() {
        return result;
    }

    /**
     * Consigue el componente de una fila.
     *
     * @param index El índice de la fila
     * @return El componente en caso de que si exista.
     * Null si no se encuentra.
     */
    public Component getComponent(int index) {
        Component component;
        try {
            component = getPanel().getComponent(index + index + 1);
            return component;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("El índice no existe \n" +
                    "Total de índices: " + panel.getComponentCount() / 2);
            return null;
        }
    }

    /**
     * Hace el cast de getComponent a JTextField
     * y lo devuelve.
     *
     * @param index El índice de la fila
     * @return El componente en caso de que si exista.
     * Null si no se encuentra.
     */
    public JTextField getJTextField(int index) {
        Component component = getComponent(index);
        if (component instanceof JTextField)
            return (JTextField) component;
        return null;
    }

    /**
     * Hace el cast de getComponent a JComboBox
     * y lo devuelve.
     *
     * @param index El índice de la fila
     * @return El componente en caso de que si exista.
     * Null si no se encuentra.
     */
    public JComboBox getJComboBox(int index) {
        Component component = getComponent(index);
        if (component instanceof JComboBox)
            return (JComboBox) component;
        return null;
    }

    /**
     * Consigue el texto de un JTextField.
     *
     * @param index El índice de la fila
     * @return El texto en caso de que si exista.
     * Null de lo contrario.
     */
    public String getTextFieldText(int index) {
        JTextField textField = getJTextField(index);
        if (textField != null)
            return textField.getText();
        return null;
    }

    /**
     * Consigue el entero de una fila.
     * Es un método muy útil para validar.
     *
     * @param index El índice de la fila
     * @return El resultado. Revisar siempre con IntegerResult#isValid ya que,
     * en caso de "false", significa que en realidad no era un int.
     * @see IntegerResult
     */
    public IntegerResult getInteger(int index) {
        JTextField textField = getJTextField(index);
        if (textField == null)
            return new IntegerResult(0, false);
        int value;
        try {
            value = Integer.parseInt(textField.getText());
            return new IntegerResult(value, true);
        } catch (NumberFormatException e) {
            return new IntegerResult(0, false);
        }
    }

    /**
     * Consigue el número decimal (double) de una fila.
     * Es un método muy útil para validar.
     *
     * @param index El índice de la fila
     * @return El resultado. Revisar siempre con DoubleResult#isValid ya que,
     * en caso de "false", significa que en realidad no era un double.
     * @see DoubleResult
     */
    public DoubleResult getDouble(int index) {
        JTextField textField = getJTextField(index);
        if (textField == null)
            return new DoubleResult(0, false);
        double value;
        try {
            value = Double.parseDouble(textField.getText());
            return new DoubleResult(value, true);
        } catch (NumberFormatException e) {
            return new DoubleResult(0, false);
        }
    }

    /**
     * Consigue el objeto seleccionado de un JComboBox.
     * Se debe hacer cast a lo que se necesite, por ejemplo String.
     *
     * @param index El índice de la fila
     * @return El objeto seleccionado en caso de que el JComboBox exista.
     * Null de lo contrario.
     */
    public Object getComboBoxItem(int index) {
        JComboBox comboBox = getJComboBox(index);
        if (comboBox != null)
            return comboBox.getSelectedItem();
        return null;
    }

    /**
     * Consigue el texto seleccionado de un JComboBox.
     * Automaticamente se hace cast a String y se devuelve.
     *
     * @param index El índice de la fila
     * @return El texto seleccionado en caso de que el JComboBox exista.
     * Null de lo contrario.
     */
    public String getComboBoxText(int index) {
        JComboBox comboBox = getJComboBox(index);
        if (comboBox != null)
            return comboBox.getSelectedItem().toString();
        return null;
    }
}
