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
     * @return 0 en caso de "YES", 1 en caso de "NO", 2 en caso de "CANCEL", -1 en caso de
     * haber cerrado la ventana
     */
    public static int anjoPane(Collection<AnjoComponent> components,
                                String title, int optionType, int messageType) {
        JPanel panel = new JPanel(new GridLayout(components.size(), 2));
        components.forEach(component -> {
            panel.add(component.getLabel());
            panel.add(component.getComponent());
        });
        int result = JOptionPane.showConfirmDialog(null, panel,
                title, optionType, messageType);
        return result;
    }

    /**
     *
     * @param components Los componentes que conforman el panel
     * @see AnjoComponent
     * @param title Título del panel
     * @param optionType Tipo de botones que se mostrarán
     * @param messageType 0 en caso de error, 1 en caso de información, 2 en caso de advertencia,
     *                    3 en caso de pregunta, -1 para no mostrar ningún icono
     * @return 0 en caso de "YES", 1 en caso de "NO", 2 en caso de "CANCEL", -1 en caso de
     * haber cerrado la ventana
     */
    public static int anjoPane(AnjoComponent[] components,
                               String title, int optionType, int messageType) {
        return anjoPane(Arrays.asList(components), title, optionType, messageType);
    }
}
