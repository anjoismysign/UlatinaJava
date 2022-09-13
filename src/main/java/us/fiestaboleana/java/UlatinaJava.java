package us.fiestaboleana.java;

import us.fiestaboleana.java.libraries.PanelLib;

public class UlatinaJava {

    public static void main(String[] args) {
        PanelLib.esEs();
        boolean test = PanelLib.requestBoolean("¿Me gusta programar?");
        PanelLib.showMessage("INFO",test ? "Sí, me gusta programar." : "No, creo que no me gusta programar.");
    }
}
