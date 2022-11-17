package us.fiestaboleana.java.libraries;

import javax.swing.*;

/**
 * @author anjoismysign
 */
public class PanelLib {
    /**
     * Translates UI buttons to Spanish
     */
    public static void esEs() {
        UIManager.put("OptionPane.cancelButtonText", "Anular");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonText", "Acepto");
        UIManager.put("OptionPane.yesButtonText", "Si");
    }

    /**
     * Pide un boolean de la forma mas elegante
     * En caso de cerrarse la ventana, se hará recursión
     * En caso del mensaje ser escrito en español,
     * se recomienda PanelLib#esEs al inicio del
     * método main
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje que se muestra mientras se pide
     *                el boolean
     * @return el boolean seleccionado
     */
    public static boolean requestBoolean(String title, String message) {
        return me.anjoismysign.anjo.libraries.PanelLib.requestBoolean(title, message);
    }

    /**
     * Pide un boolean de la forma mas elegante
     * En caso de cerrarse la ventana, se hará recursión
     * En caso del mensaje ser escrito en español,
     * se recomienda PanelLib#esEs al inicio del
     * método main
     *
     * @param message Mensaje que se muestra mientras se pide
     *                el boolean
     * @return el boolean seleccionado
     */
    public static boolean requestBoolean(String message) {
        return requestBoolean("", message);
    }

    /**
     * Pide un boolean mediante un JOptionPane
     * De no ingresarse "si" o "no", se hace recursión
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param titulo  Título del JOptionPane
     * @param mensaje Mensaje mostrado antes de "Ingrese 'si' o 'no'"
     * @return true en caso de "si", false en caso de "no"
     */
    public static boolean confirmar(String titulo, String mensaje) {
        return me.anjoismysign.anjo.libraries.PanelLib.confirmar(titulo, mensaje, "'%input%' no es ni 'si' ni 'no'");
    }

    /**
     * Pide un boolean mediante un JOptionPane
     * De no ingresarse "si" o "no", se hace recursión
     *
     * @param mensaje Mensaje mostrado antes de "Ingrese 'si' o 'no'"
     * @return true en caso de "si", false en caso de "no"
     */
    public static boolean confirmar(String mensaje) {
        return confirmar("", mensaje);
    }

    /**
     * Pide un boolean mediante un JOptionPane
     * De no ingresarse "yes" o "no", se hace recursión
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje mostrado antes de "Type 'yes' or 'no'"
     * @return true en caso de "yes", false en caso de "no"
     */
    public static boolean confirm(String title, String message) {
        return me.anjoismysign.anjo.libraries.PanelLib.confirm(title, message, "'%input%' is neither 'yes' or 'no'");
    }

    /**
     * Pide un boolean mediante un JOptionPane
     * De no ingresarse "yes" o "no", se hace recursión
     *
     * @param message Mensaje mostrado antes de "Type 'yes' or 'no'"
     * @return true en caso de "yes", false en caso de "no"
     */
    public static boolean confirm(String message) {
        return confirm("", message);
    }

    /**
     * Pide un entero (int/integer) mediante un JOptionPane
     * Si no se introduce un entero, se hara recursión hasta conseguir el entero
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje que se muestra mientras se pide el entero
     * @return el entero
     */
    public static int requestInteger(String title, String message) {
        return me.anjoismysign.anjo.libraries.PanelLib.requestInteger(title, message, "'%input%' no es un entero\n" +
                "Integer (entero): '-2147483648' hasta '2147483647'\n" +
                "Ejemplo de entero: 17");
    }

    /**
     * Pide un entero (int/integer) mediante un JOptionPane
     * Si no se introduce un entero, se hara recursión hasta conseguir el entero
     *
     * @param message Mensaje que se muestra mientras se pide el entero
     * @return el entero
     */
    public static int requestInteger(String message) {
        return requestInteger("", message);
    }

    /**
     * Pide un numero decimal (double) mediante un JOptionPane
     * Si no se introduce un numero decimal, se hara recursión hasta conseguir el numero decimal
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje que se muestra mientras se pide el numero decimal
     * @return el numero decimal
     */
    public static double requestDouble(String title, String message) {
        return me.anjoismysign.anjo.libraries.PanelLib.requestDouble(title, message, "'%input%' no es un número decimal\n" +
                "Double (numero decimal): '-1.7976931348623157E308' hasta '1.7976931348623157E308'\n" +
                "Ejemplo de numero decimal: 17.5");
    }

    /**
     * Pide un numero decimal (double) mediante un JOptionPane
     * Si no se introduce un numero decimal, se hara recursión hasta conseguir el numero decimal
     *
     * @param message Mensaje que se muestra mientras se pide el numero decimal
     * @return el numero decimal
     */
    public static double requestDouble(String message) {
        return requestDouble("", message);
    }

    /**
     * Pide una cadena de texto (String) mediante un JOptionPane
     * Si la cadena de texto está vacía o es null, se hara recursión hasta conseguir una cadena de texto
     *
     * @param message Mensaje que se muestra mientras se pide la cadena de texto
     * @return la cadena de texto
     */
    public static String requestString(String message) {
        return requestString("", message);
    }

    /**
     * Pide una cadena de texto (String) mediante un JOptionPane
     * La diferencia es que este método permite poner un título al JOptionPane
     * Si la cadena de texto está vacía o es null, se hara recursión hasta conseguir una cadena de texto
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje que se muestra mientras se pide la cadena de texto
     * @return la cadena de texto
     */
    public static String requestString(String title, String message) {
        return me.anjoismysign.anjo.libraries.PanelLib.requestString(title, message, "Lo introducido no es válido");
    }

    /**
     * Muestra un mensaje mediante un JOptionPane
     *
     * @param message Mensaje que se muestra
     */
    public static void showMessage(String message) {
        showMessage("", message);
    }

    /**
     * Muestra un mensaje mediante un JOptionPane
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param title   Título del JOptionPane
     * @param message Mensaje que se muestra
     */
    public static void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, -1);
    }
}