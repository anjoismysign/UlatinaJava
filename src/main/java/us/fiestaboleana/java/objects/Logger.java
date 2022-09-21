package us.fiestaboleana.java.objects;

public class Logger {

    public void log(String message) {
        System.out.println(message);
    }

    public void debug(String message) {
        log("DEBUG: " + message);
        log("DEBUG: " + message);
        log("DEBUG: " + message);
    }

    public void error(String message) {
        log("ERROR: " + message);
        log("ERROR: " + message);
        log("ERROR: " + message);
    }

    public void singleError(String message) {
        log("ERROR: " + message);
    }
}
