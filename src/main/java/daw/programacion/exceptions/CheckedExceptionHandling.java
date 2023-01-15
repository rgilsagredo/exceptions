package daw.programacion.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionHandling {

    /* Aquí vamos a ver cómo deben manejarse excepciones checked */

    /*
     * intentamos leer un fichero (que no existe). La clase FileReader (que se
     * encarga de leer fichero)
     * lanza una excepcion de tipo CHECKED y por tanto nos obliga a controlarla (la
     * propia clase
     * ya sabe que al intentar leer un fichero podemos encontrarnos con problemas y
     * nos obliga a lidiar
     * con ellos)
     */

    /*
     * Tenemos varias opciones para actuar. Si el compilador me avisa de una CHECKED
     * exception,
     * el código que puede explotar hay que meterlo en un bloque try (es decir,
     * intenta hacer esto).
     * Si el código lanza excepcion, en el momento (linea de código) en que eso
     * ocurra, la parte del try
     * deja de ser ejecutada, y toma el control del programa la parte del catch (si
     * es que se coge la excepción correcta).
     * En caso de CHECKED exceptions, el IDE te dice que tipo de excepción está
     * lanzando, y por tnato sabes qué hay que poner en el catch.
     * Si no sabes que te va a saltar, puedes cubrirte el culo con un Excepction
     * (como todas las excepciones son subclases suyas, seguro que lo pilla). Pero
     * siempre mejor
     * ser específico, ya que te va a ayudar a solucionar los problemas antes.
     * 
     * NOTA: sobre cómo llamar a los objetos exception, hay gente que los llama
     * genéricamente "ex", y otros
     * que usan las inciales de la clase. Yo voy a usar las iniciales de la clase.
     * 
     * Cuando el código se ejecuta y ocurre la excecpión en el try, si el catch la
     * coge (es deceir, le hemos
     * dicho que pille el tipo concreto de excecpión que lanza lo del try), se
     * ejecuta el código que hay en catch,
     * como manera de evitar que el programa te explote en la cara. En el catch, en
     * las excecpiones checked, puedes
     * poner un mensae amable para el usuario de que el programa ha terminado debido
     * a que tal o cual.
     * Es decir, no ha ido nada dentro de nuestro (usuario y programador) control
     * mal, simplemente ahora el
     * código no puede correr de la manera esperada
     * 
     */

    // este método, cuando falle el FileReader, devolverá un mensaje, y el programa
    // terminará sin problemas
    public static void leerFichero_v1() {
        String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
        File file = new File(pathToFile);
        try {
            FileReader fr = new FileReader(file);
            System.out.println("Esta linea de código no se ejecuta, porque tengo una excepción antes");
        } catch (FileNotFoundException fnfe) {
            System.out.println("El fichero no existe");
        }
    }

    public static void leerFichero_v2() {
        String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
        File file = new File(pathToFile);
        try {
            FileReader fr = new FileReader(file);
            System.out.println("Esta linea de código no se ejecuta, porque tengo una excepción antes");
        } catch (Exception e) { // este es el catch pokemon: pilla todas las excepciones
            System.out.println("El fichero no existe");
        }
    }

    /**
     * Mas interesante es que el objeto en el catch tiene info de que ha pasado. En
     * general nos interesan
     * 2 métodos, uno es e.getMessage() --> me dice que ha pasado y
     * e.printStackTrace() --> te muestra la pila
     * de llamadas ue llevan a la excepcion. Aquí se pueden encontrar más:
     * https://www.tutorialspoint.com/java/java_exceptions.htm
     */

    public static void leerFichero_v3() {
        String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
        File file = new File(pathToFile);
        try {
            FileReader fr = new FileReader(file);
            System.out.println("Esta linea de código no se ejecuta, porque tengo una excepción antes");
        } catch (Exception e) { // este es el catch pokemon: pilla todas las excepciones
            System.out.println(e.getMessage()); // dime que ha pasado
        }
    }

    public static void leerFichero_v4() {
        String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
        File file = new File(pathToFile);
        try {
            FileReader fr = new FileReader(file);
            System.out.println("Esta linea de código no se ejecuta, porque tengo una excepción antes");
        } catch (Exception e) { // este es el catch pokemon: pilla todas las excepciones
            e.printStackTrace(); // dime la pila de llamadas hasta el error. También te da el mensaje
        }
    } // aquí, aprendr a leer el stack de llamadas

    // el programa explota si no pillamos la excepción correcta. De hecho, ni me
    // deja compilar
    /*
     * public static void leerFichero_v5() {
     * String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
     * File file = new File(pathToFile);
     * try {
     * FileReader fr = new FileReader(file);
     * System.out.
     * println("Esta linea de código no se ejecuta, porque tengo una excepción antes"
     * );
     * } catch (ArithmeticException e) {
     * e.printStackTrace(); // dime la pila de llamadas hasta el error. También te
     * da el mensaje
     * }
     * }
     */

    /*
     * No siempre hay que manejar la excepción según te salga, a veces puedes
     * pasarle el marrón a otro método
     * Esto es porque las excepciones, según se lanzan, van hacia "arriba" en la
     * pila de llamadas
     * hasta que alguien se encarga de ellas
     */

    // si yo digo que este método lanza una excepción, ya se encargará otro método
    // de la pila que lo llame de manejar la excecpón y no tengo error de
    // compilación (aquí)
    // pero lo tendré en el método que llame a este
    public static void leerFichero_v6() throws FileNotFoundException {
        String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
        File file = new File(pathToFile);
        FileReader fr = new FileReader(file);
        System.out.println("Esta linea de código no se ejecuta, porque tengo una excepción antes");

    }

}
