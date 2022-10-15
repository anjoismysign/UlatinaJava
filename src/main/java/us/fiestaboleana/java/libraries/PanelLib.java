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
        JOptionPane.setRootFrame(null);
        int x = JOptionPane.showConfirmDialog(null, message, title,
                0, -1);
        if (x == JOptionPane.CLOSED_OPTION)
            return requestBoolean(title, message);
        return x == 0 ? true : false;
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
        String input = PanelLib.requestString(mensaje + " \nIngrese 'si' o 'no'");
        String minusculas = input.toLowerCase();
        if (!minusculas.equals("si") && !minusculas.equals("no")) {
            PanelLib.showMessage(titulo, "'" + input + "' no es ni 'si' ni 'no'");
            return confirmar(titulo, mensaje);
        }
        if (minusculas.equals("si"))
            return true;
        else
            return false;
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
        String input = PanelLib.requestString(message + " \nType 'yes' or 'no'");
        String lowercased = input.toLowerCase();
        if (!lowercased.equals("yes") && !lowercased.equals("no")) {
            PanelLib.showMessage(title, "'" + input + "' is neither 'yes' or 'no'");
            return confirm(title, message);
        }
        if (lowercased.equals("yes"))
            return true;
        else
            return false;
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
        String input = requestString(title, message);
        int x = 0;
        try {
            x = Integer.parseInt(input);
            return x;
        } catch (NumberFormatException e) {
            showMessage("ERROR", "'" + input + "' no es un entero\n" +
                    "Integer (entero): '-2147483648' hasta '2147483647'\n" +
                    "Ejemplo de entero: 17");
            return requestInteger(title, message);
        }
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
        String input = requestString(title, message);
        double x = 0;
        try {
            x = Double.parseDouble(input);
            return x;
        } catch (NumberFormatException e) {
            showMessage("ERROR", "'" + input + "' no es un numero decimal\n" +
                    "Ejemplo de double (numero decimal): '3.14'");
            return requestDouble(title, message);
        }
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
        String input = requestString("", message);
        return input;
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
        String input = JOptionPane.showInputDialog(null, message, title, -1);
        if (input == null || input.length() == 0) {
            showMessage("ERROR", "Lo introducido está vacío");
            return requestString(title, message);
        }
        return input;
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