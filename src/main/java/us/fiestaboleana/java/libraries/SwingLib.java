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
            component = panel.getComponent(index*2);
            return component;
        } catch (IndexOutOfBoundsException e){
            System.out.println("El índice no existe \n" +
                    "Total de índices (en caso de ser un JPanel de AnjoPane): " + panel.getComponentCount()/2);
            return null;
        }
    }
}
