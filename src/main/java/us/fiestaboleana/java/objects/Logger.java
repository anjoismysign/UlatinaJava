package us.fiestaboleana.java.objects;

/**
 * @author anjoismysign
 */
public class Logger {
    /**
     * Imprime un mensaje en la consola
     *
     * @param message mensaje a imprimir
     */
    public void log(String message) {
        System.out.println(message);
    }

    /**
     * Imprime un mensaje en la consola con intención de ser visible para DEBUG
     *
     * @param message mensaje a imprimir
     */
    public void debug(String message) {
        log("DEBUG: " + message);
        log("DEBUG: " + message);
        log("DEBUG: " + message);
    }

    /**
     * Imprime un mensaje en la consola con intención de ser visible por ERROR
     *
     * @param message mensaje a imprimir
     */
    public void error(String message) {
        log("ERROR: " + message);
        log("ERROR: " + message);
        log("ERROR: " + message);
    }

    /**
     * Imprime un mensaje en la consola con intención de ser visible por ERROR (solamente una vez)
     *
     * @param message mensaje a imprimir
     */
    public void singleError(String message) {
        log("ERROR: " + message);
    }
}
