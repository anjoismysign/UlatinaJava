package us.fiestaboleana.java.libraries;

import javax.swing.*;

public class PanelLib {

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

    public static String requestString(String message) {
        String input = requestString("", message);
        return input;
    }

    public static String requestString(String title, String message) {
        String input = JOptionPane.showInputDialog(null, message, title, -1);
        return input;
    }

    public static void showMessage(String message) {
        showMessage("", message);
    }

    public static void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, -1);
    }
}