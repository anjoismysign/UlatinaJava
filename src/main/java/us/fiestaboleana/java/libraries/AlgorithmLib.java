package us.fiestaboleana.java.libraries;

/**
 * @author anjoismysign
 */
public class AlgorithmLib {

    /**
     * Ejecuta código mientras se cumpla una condición
     * La diferencia de este método es que permite poner un título al JOptionPane
     *
     * @param runnable código que se ejecutará mientras se desee
     * @param title    Título del JOptionPane
     * @param message  Mensaje que se muestra antes de agregar otro elemento
     */
    public static void dynamicRun(Runnable runnable, String title, String message) {
        me.anjoismysign.anjo.libraries.AlgorithmLib.dynamicRun(runnable, title, message);
    }

    /**
     * Ejecuta código mientras se cumpla una condición
     *
     * @param runnable código que se ejecutará mientras se desee
     * @param message  Mensaje que se muestra antes de agregar otro elemento
     */
    public static void dynamicRun(Runnable runnable, String message) {
        dynamicRun(runnable, "", message);
    }
}
