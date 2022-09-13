package us.fiestaboleana.java.libraries;

import us.fiestaboleana.java.objects.AnjoComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

public class SwingLib {

    /**
     *
     * @param components Los componentes que conforman el panel
     * @see AnjoComponent
     * @param title Título del panel
     * @param optionType Tipo de botones que se mostrarán
     * @param messageType 0 en caso de error, 1 en caso de información, 2 en caso de advertencia,
     *                    3 en caso de pregunta, -1 para no mostrar ningún icono
     * @param expecting 0 en caso de "YES", 1 en caso de "NO", 2 en caso de "CANCEL", -1 en caso de
     * haber cerrado la ventana
     */
    public static JPanel anjoPane(Collection<AnjoComponent> components,
                                String title, int optionType, int messageType,
                                int expecting){
        JPanel panel = new JPanel(new GridLayout(components.size(), 2));
        components.forEach(component -> {
            panel.add(component.getLabel());
            panel.add(component.getComponent());
        });
        int result = JOptionPane.showConfirmDialog(null, panel,
                title, optionType, messageType);
        if (result == expecting)
            return panel;
        return null;
    }

    /**
     *
     * @param components Los componentes que conforman el panel
     * @see AnjoComponent
     * @param title Título del panel
     * @param optionType Tipo de botones que se mostrarán
     * @param messageType 0 en caso de error, 1 en caso de información, 2 en caso de advertencia,
     *                    3 en caso de pregunta, -1 para no mostrar ningún icono
     * @param expecting 0 en caso de "YES", 1 en caso de "NO", 2 en caso de "CANCEL", -1 en caso de
     * haber cerrado la ventana
     */
    public static JPanel anjoPane(AnjoComponent[] components,
                                  String title, int optionType, int messageType,
                                  int expecting){
        return anjoPane(Arrays.asList(components), title, optionType, messageType, expecting);
    }

    /**
     * Consigue el componente de una fila de un AnjoPane.
     * Primero hay que asegurarse que el JPanel le pertenezca
     * a un panel creado con SwingLib#anjoPane.
     * @param panel El panel de AnjoPane
     * @param index El índice de la fila
     * @return El componente en caso de que si exista.
     * Null si no se encuentra.
     */
    public static Component getAnjoJComponentFromJPanel(JPanel panel, int index){
        Component component;
        try {
            component = panel.getComponent(index+index+1);
            return component;
        } catch (IndexOutOfBoundsException e){
            System.out.println("El índice no existe \n" +
                    "Total de índices (en caso de ser un JPanel de AnjoPane): " + panel.getComponentCount()/2);
            return null;
        }
    }

    /**
     * Hace el cast de getAnjoJComponentFromJPanel a JTextField
     * y lo devuelve.
     * @param panel El panel de AnjoPane
     * @param index El índice de la fila
     * @return El componente en caso de que si exista.
     * Null si no se encuentra.
     */
    public static JTextField getAnjoJTextFieldFromJPanel(JPanel panel, int index){
        Component component = getAnjoJComponentFromJPanel(panel, index);
        if (component instanceof JTextField)
            return (JTextField) component;
        return null;
    }

    /**
     * Hace el cast de getAnjoJComponentFromJPanel a JComboBox
     * y lo devuelve.
     * @param panel El panel de AnjoPane
     * @param index El índice de la fila
     * @return El componente en caso de que si exista.
     * Null si no se encuentra.
     */
    public static JComboBox getAnjoJComboBoxFromJPanel(JPanel panel, int index){
        Component component = getAnjoJComponentFromJPanel(panel, index);
        if (component instanceof JComboBox)
            return (JComboBox) component;
        return null;
    }

    /**
     * Consigue el texto de un JTextField de un AnjoPane.
     * @param panel El panel de AnjoPane
     * @param index El índice de la fila
     * @return El texto en caso de que si exista.
     * Null de lo contrario.
     */
    public static String getTextFromAnjoJTextField(JPanel panel, int index){
        JTextField textField = getAnjoJTextFieldFromJPanel(panel, index);
        if (textField != null)
            return textField.getText();
        return null;
    }

    /**
     * Consigue el objeto seleccionado de un JComboBox de un AnjoPane.
     * Se debe castear a lo que se necesite, por ejemplo String.
     * @param panel El panel de AnjoPane
     * @param index El índice de la fila
     * @return El objeto seleccionado en caso de que exista.
     * Null de lo contrario.
     */
    public static Object getSelectedItemFromAnjoJComboBox(JPanel panel, int index){
        JComboBox comboBox = getAnjoJComboBoxFromJPanel(panel, index);
        if (comboBox != null)
            return comboBox.getSelectedItem();
        return null;
    }


}
