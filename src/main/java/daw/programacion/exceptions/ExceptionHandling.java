package daw.programacion.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {
    /*
     * Ya se ha visto en las otras clases, pero la manera de manjeras (handle)
     * exceptions es
     * con bloques try-catch. LAs exception CHECKED (de compilación) estamos
     * obligados a manejarlas,
     * ya sea rodeando al método/clase que lanza la excepción de un try-catch según
     * se invoca,
     * o bien diceindo que el método (donde se declara la clase/etodo que podría
     * lanzar una exception)
     * THROWS una clase de excpeción, es decir, pa´sandole el marrón a otro
     */

    // exception manejada según "sale"
    public static void leerFichero(String rutaAFichero) {

        try {
            FileReader fr = new FileReader(rutaAFichero);
        } catch (FileNotFoundException e) {
            System.out.println("no ha sido capaz de leer el fichero");
            e.printStackTrace();
        }
    }

    // exception que se pasa al método que llame a este método
    public static void leerFichero_v2(String rutaAFichero) throws FileNotFoundException {
        FileReader fr = new FileReader(rutaAFichero);

    }

    /*
     * Podemos tener varios catch en un mismo try, para pillar diversas excepciones
     * que pudieran surgir, y darles distinto tratamiento
     */
    public static void variosCatch(String rutaAFichero) {
        try {
            System.out.println(rutaAFichero.length());
            FileReader fr = new FileReader(rutaAFichero);
        } catch (NullPointerException npe) {
            System.out.println("Pillamos aquí una NullPointerException");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Aqui pillamos un FileNotFoundException");
        }
    }

    /*
     * También podemos poner varias excepciones en un catch, pero todas llevarán el
     * mismo tratamiento
     */
    public static void variosCatch_v2(String rutaAFichero) {
        try {
            System.out.println(rutaAFichero.length());
            FileReader fr = new FileReader(rutaAFichero);
        } catch (NullPointerException | FileNotFoundException ex) {
            System.out.println("aquí ex será de tipo NullPointer o FileNotFound, la que se lance");
        }
    }

    /*
     * Como las exceptions tienen una jerarquía (dada por clases y subclases) si
     * tenemos varios bloques catch
     * el orden (puede que) importa. Hay que pillar primero las exceptions más
     * específicas
     */
    public static void variosCatch_v3(String rutaAFichero) {
        try {
            FileReader fr = new FileReader(rutaAFichero);
            int value = fr.read();
        } catch (FileNotFoundException fnfe) {
            //
        } catch (IOException ioe) {
            //
        }
    }

    public static void variosCatch_v4(String rutaAFichero) {
        try {
            FileReader fr = new FileReader(rutaAFichero);
            int value = fr.read();
        } catch (IOException ioe) {
            //
        } catch (FileNotFoundException fnfe) {
            // el compilador se queja de que exta exception ya está siendo manejada por
            // IOException.
            // lo que pasa es que FileNotFoundException es subclase de IOException
        }
    }

    /*
     * PDTE:
     * finally block
     * hacer que se lancen exceptions en tu código (ejemplo cuenta)
     * crear tus propias exceptions
     * testear que se lanzan exceptions
     * Ya que estamos, test parametrizados??
     */

}
