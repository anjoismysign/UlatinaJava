package us.fiestaboleana.java.objects;

public final class Logger {

    public void log(String message) {
        System.out.println(message);
    }

    public void debug(String message) {
        log("DEBUG: " + message);
        log("DEBUG: " + message);
        log("DEBUG: " + message);
    }
}
