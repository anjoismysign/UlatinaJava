package us.fiestaboleana.java.libraries;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


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
        toPrint.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("'" + scanner.next() + "' no es un entero");
            System.out.println("Integer (entero): '-2147483648' hasta '2147483647'");
            System.out.println("Ejemplo de entero: 17");
            return scanInt(toPrint);
        }
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
        toPrint.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            System.out.println("'" + scanner.next() + "' no es un numero decimal");
            System.out.println("Ejemplo de double (numero decimal): '3.14'");
            return scanDouble(toPrint);
        }
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