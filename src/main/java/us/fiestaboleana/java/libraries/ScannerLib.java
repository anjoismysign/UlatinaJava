package us.fiestaboleana.java.libraries;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author anjoismysign
 */
public class ScannerLib {

    /**
     * forma elegante de consultar por un entero
     * de ser posible se devuelve el valor, de lo
     * contrario se vuelve a consultar por el valor
     *
     * @param toPrint lista de mensajes que desee
     *                imprimir sobre System.out.println()
     *                antes de escaneár el entero
     * @return entero consultado
     */
    public static int scanInt(List<String> toPrint) {
        return me.anjoismysign.anjo.libraries.ScannerLib.scanInt(toPrint, "'%input%' no es un entero. \n" +
                "Integer (entero): '-2147483648' hasta '2147483647' \n" +
                "Ejemplo de entero: 17");
    }

    /**
     * forma elegante de consultar por un double
     * de ser posible se devuelve el valor, de lo
     * contrario se vuelve a consultar por el valor
     *
     * @param toPrint lista de mensajes que desee
     *                imprimir sobre System.out.println()
     *                antes de escaneár el double
     * @return double consultado
     */
    public static double scanDouble(List<String> toPrint) {
        return me.anjoismysign.anjo.libraries.ScannerLib.scanDouble(toPrint, "'%input%' no es un número decimal. \n" +
                "Ejemplo de double (numero decimal): '3.14'");
    }

    /**
     * forma elegante de consultar por una cadena de texto
     *
     * @param toPrint lista de mensajes que desee
     *                imprimir sobre System.out.println()
     *                antes de escaneár la cadena
     * @return la cadena
     */
    public static String scanString(List<String> toPrint) {
        toPrint.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * forma elegante de consultar por un entero
     * de ser posible se devuelve el valor, de lo
     * contrario se vuelve a consultar por el valor
     *
     * @param toPrint mensaje que desee imprimir sobre
     *                System.out.println() antes de
     *                escaneár el entero
     * @return el entero
     */
    public static int scanInt(String toPrint) {
        return scanInt(Collections.singletonList(toPrint));
    }

    /**
     * forma elegante de consultar por un double
     * de ser posible se devuelve el valor, de lo
     * contrario se vuelve a consultar por el valor
     *
     * @param toPrint mensaje que desee imprimir sobre
     *                System.out.println() antes de
     *                escaneár el double
     * @return el double
     */
    public static double scanDouble(String toPrint) {
        return scanDouble(Collections.singletonList(toPrint));
    }

    /**
     * forma elegante de consultar por una cadena de texto
     *
     * @param toPrint mensaje que desee imprimir sobre
     *                System.out.println() antes de
     *                escaneár la cadena
     * @return la cadena
     */
    public static String scanString(String toPrint) {
        return scanString(Collections.singletonList(toPrint));
    }
}