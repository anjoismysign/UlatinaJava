package us.fiestaboleana.java;

import us.fiestaboleana.java.libraries.AlgorithmLib;
import us.fiestaboleana.java.libraries.PanelLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UlatinaJava {

    public static void main(String[] args) {
        PanelLib.esEs();
        List<String> cursos = new ArrayList<>();
        AlgorithmLib.dynamicRun(()->
            cursos.add(PanelLib.requestString("ULATINA",
                    "Ingrese curso")),
                "¿Desea ingresar más cursos?");
        PanelLib.showMessage("INFO", Arrays.toString(cursos.parallelStream().toArray()));
    }
}
