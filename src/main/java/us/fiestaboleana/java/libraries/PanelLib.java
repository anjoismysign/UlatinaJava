package us.fiestaboleana.java.libraries;

import javax.swing.*;

public class PanelLib {

    /**
     * Pide un entero (int/integer) mediante un JOptionPane
     * Si no se introduce un entero, se hara recursión hasta conseguir el entero
     * @param message Mensaje que se muestra mientras se pide el entero
     * @return el entero
     */
    public static int requestInteger(String message) {
        String input = requestString(message);
        int x = 0;
        try {
            x = Integer.parseInt(input);
            return x;
        } catch (NumberFormatException e) {
            showMessage("ERROR", "'" + input + "' no es un entero\n" +
                    "Integer (entero): '-2147483648' hasta '2147483647'\n" +
                    "Ejemplo de entero: 17");
            return requestInteger(message);
        }
    }

    /**
     * Pide un numero decimal (double) mediante un JOptionPane
     * Si no se introduce un numero decimal, se hara recursión hasta conseguir el numero decimal
     * @param message Mensaje que se muestra mientras se pide el numero decimal
     * @return el numero decimal
     */
    public static double requestDouble(String message) {
        String input = requestString(message);
        double x = 0;
        try {
            x = Double.parseDouble(input);
            return x;
        } catch (NumberFormatException e) {
            showMessage("ERROR", "'" + input + "' no es un numero decimal\n" +
                    "Ejemplo de double (numero decimal): '3.14'");
            return requestDouble(message);
        }
    }

    /**
     * Pide una cadena de texto (String) mediante un JOptionPane
     * Si la cadena de texto está vacía o es null, se hara recursión hasta conseguir una cadena de texto
     * @param message Mensaje que se muestra mientras se pide la cadena de texto
     * @return la cadena de texto
     */
    public static String requestString(String message) {
        String input = requestString("", message);
        return input;
    }

    /**
     * Pide una cadena de texto (String) mediante un JOptionPane
     * La diferencia es que este método permite poner un título al JOptionPane
     * Si la cadena de texto está vacía o es null, se hara recursión hasta conseguir una cadena de texto
     * @param title Título del JOptionPane
     * @param message Mensaje que se muestra mientras se pide la cadena de texto
     * @return la cadena de texto
     */
    public static String requestString(String title, String message) {
        String input = JOptionPane.showInputDialog(null, message, title, -1);
        if (input == null || input.length() == 0) {
            showMessage("ERROR", "Lo introducido está vacío");
            return requestString(title, message);
        }
        return input;
    }

    /**
     * Muestra un mensaje mediante un JOptionPane
     * @param message Mensaje que se muestra
     */
    public static void showMessage(String message) {
        showMessage("", message);
    }

    /**
     * Muestra un mensaje mediante un JOptionPane
     * La diferencia de este método es que permite poner un título al JOptionPane
     * @param title Título del JOptionPane
     * @param message Mensaje que se muestra
     */
    public static void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, -1);
    }
}