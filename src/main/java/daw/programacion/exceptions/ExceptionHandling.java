package daw.programacion.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.catalog.Catalog;

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

    // public static void variosCatch_v4(String rutaAFichero) {
    //     try {
    //         FileReader fr = new FileReader(rutaAFichero);
    //         int value = fr.read();
    //     } catch (IOException ioe) {
    //         //
    //     } catch (FileNotFoundException fnfe) {
    //         // el compilador se queja de que exta exception ya está siendo manejada por
    //         // IOException.
    //         // lo que pasa es que FileNotFoundException es subclase de IOException
    //     }
    // }

    /*
     * try-catch-finally
     * Puedo añadir un 3er bloque de código al try-catch, que es el finally. Lo que
     * haya en finally SE
     * EJECUTA SIEMPRE, HAYA EXPECTION O NO. Es más, se ejecuta tan "siempre" que
     * sobreescribe
     * (si procede) comandos de los bloques try y catch.
     * El propósito de finally es código que se va a ejecutar siempre, haya
     * excepction o no.
     * Nomalmente se usa para cerrar recursos (no lo hemos visto aun, el ejemplo
     * bueno es el filereader.
     * Cuando abres con filereader un fichero, este se queda "abierto" por tu
     * programa, y el fichero es inutilizable
     * para el resto de programas. Para que tu programa lo libere, tienes que decir
     * fr.close(). Si queda un
     * objeto fr abierto, hay una excepción, y unca se cierra, tu recurso nunca es
     * liberado. Finally viene a "resolverte" este problema)
     */

    public static void finallyBlock(String rutaAFichero) {
        FileReader fr = null;
        try {
            fr = new FileReader(rutaAFichero);
            fr.read(); // si esto da error, fr.close nunca se ejecutará
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // infelizmente, hay que declarar fr fuera, porque si no, el compilador no lo ve
              // aquí
              // es porque si salta la exception en la declaración, fr nunca exixtirá
        }
    } // en cualquier caso, este código es muy feo, es mejor usar try-with-resources,
      // que se encarga el solito de cerrar las cosas
      // que explotan

      public static void tryWithResources(String rutaAFichero){
        try(FileReader fr = new FileReader(rutaAFichero)){
            System.out.println("algo");
        } catch(IOException ex) {
            ex.printStackTrace();
        } // de esta manera no me hace falta un finally para cerrar recursos, si hay una exception o no, se hace solo
      }

    /*
     * PDTE:
     * crear tus propias exceptions
     */

}
