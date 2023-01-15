package daw.programacion.exceptions;

import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        /*
         * 
         * Puede ocurrir que al correr un programa los métodos fallen. De hecho se ha
         * visto mil veces con los arrays: aunque el código, antes de ser ejecutado,
         * está en principio bien, a la hora de la ejecución nos encontramos con un
         * indexOutOfBounds que no hemos previsto y el programa finaliza erronaemane
         */

        // ejemplo de un error en tiempo de ejecución

        // int[] array = {1,2,3};
        // System.out.println(array[5]); // de primeras no vemos que haya ningún fallo
        // en la escritura del programa, pero este código no ejecuta

        /*
         * 
         * Lo errores que ocurren en la ejecución del programa alterando el flujo normal
         * se llama excepciones. El llevar un buen control de excepciones permite:
         * - separar código que controla excepciones del resto (que tendrá otro
         * propósito)
         * - propagar errores sobre una pila de llamadas
         * - agrupar diferentes tipos de errores y proponer su tratamiento
         */

        /*
         * 
         * Esecenarios típicos en los que ocurren excepciones:
         * - el usuario de la aplicación mete datos incorrectos (invalidArgument)
         * - se intenta abrir un fichero que no existe (IOException)
         * - Problema de conexión (de red, a una DB)
         * - la JVM se queda sin memoria
         * 
         * En estos escenarios se ven las 3 categorías de excepciones que tiene java:
         * por error del usuario, por error del programador, o por causas externas
         * 
         */

        /**
         * 
         * Excepciones en Java. Hay 3, checked, unchecked, y error.
         * OJO: todas las excepciones son OBJETOS (instancias de una clase) que
         * contienen información de lo que ha ido mal
         * 
         * como las excepciones son objetos, vienen de clases (que van heredando de
         * otras clases, es decir, se van
         * especializando, es decir, controlan cosas mas finas. Ejemplo: Si pillo un
         * error de que no se puede leer un
         * fichero, es particular estoy pillando que el fichero no existe)
         * 
         * Checked: son las excepciones que estamos obligados a anticipar y controlar.
         * De hecho, nos obliga el compilador
         * (es decir, yo no puedo hacer un build de mi aplicación sin haber controlado
         * esta excepción).
         * listado de excepciones comunes:
         * https://www.codejava.net/java-core/exception/java-checked-and-unchecked-exceptions
         * 
         * Ejemplo clasico de esta excepción es al intentar leer un fichero (puede que
         * el fichero no exista --
         * por habe escrito mal el nombre, porque se ha borrado...)
         * 
         */

        // código de una checked exception
        // String pathToFile = "C:\\coding\\java\\clase\\exceptions\\hola.txt";
        // File file = new File(pathToFile);
        // FileReader fr = new FileReader(file);

        /**
         * Si intentamos compilar el código de arriba nos tiene que explotar en la cara,
         * pues el propio compilador dirá
         * que tenemos una posible excepcion sin manejar. Tiene sentido, pues el
         * compiler se adelanta a lo dicho antes:
         * que el fichero (por las razonas que sean) no exista, lo cual haría que
         * nuestro programa terminase
         * abruptamente. Es nuestro problema como programadores tener esta situación en
         * la cabeza y darle solución,
         * es decir, en caso de que al ir a leer el fichero efectivamente no exista,
         * ¿qué tiene que hacer la aplicación?
         */

        /**
         * En general, hay que preocuparse "poco" por las excepciones checked porque nos
         * avisa el compilador
         * de que las tenemos ahí y que hay que darles un manejo. Suelen tener que ver
         * siempre con
         * actividades de I/O, conexiones a DBs, no poder hacer ciertas acciones (ya
         * vimos que para poder clonar
         * un objeto hay que implementar un
         * método y una interfaz, sin ambos, tenemos
         * una checked exception).
         * 
         * Un poco más adelante lo vemos con más detalle, pero las excepciones tienen
         * una jerarquía (de lo más general, es decir *alguna* exception, a cosas más
         * concretas,
         * por ejemplo: no existe el fichero).
         * Pues en la jerarquía de las exceptions,
         * las Checked son las que están bajo java.lang.Exception y NO bajo
         * java.lang.RuntimeException.
         * Ver arbol de jerarquías aquí:
         * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/package-tree.html
         * 
         */

        /**
         * UNCHECKED Exceptions -- son las que ocurren en tiempo de ejecucicón, es
         * decir, el
         * compilador no las pilla. Son bugs, error el la lógica del programa, usar una
         * API mal...
         * Son errores de programación, y es tu problema evitar que ocurran. Es decir,
         * si en tu programa
         * te lanza un IndexOutOfBounds, tú tienes que buscarte la vida para que ese
         * error no ocurra,
         * no vale poner un try-catch. La manera de evitar estas cosas es programar bien
         * y hacer tests.
         * 
         * En la jerarquía de las excepciones, las unckecked son todas las que están por
         * debajo de RuntimeException.
         * Las más típicas son:
         * - NullPointerException -- hemos pasado un objeto que no existe
         * - ArithmeticException -- dividir por cero
         * - IllegalArgumentException -- pasas un parámetro inválido
         * - IndexOutOfBounds -- intentar acceder a un elemento de un array que no
         * existe
         * - NumberFormatException -- suele ocurrir cuando intentar parsear a numero una
         * string no numérica
         */

        // ejemplos -- null ponter
        // String texto = null;
        // metodo(texto);

        // arithmetic
        // System.out.println(5 / 0);

        // number format
        // int n = Integer.parseInt("asdf");

        // para illegalArgument, mejor un ejemplo más adelante con la clase Cuenta,
        // donde vamos a querer
        // evitar que el método meterDinero acepte dinero negativo

        /**
         * Por últimmo, tienes los Error. Estos te los comes, son problemas fuera del
         * alcance de
         * programador o usuario. Típicamente, que la JVM se quede sin memoria.
         * 
         */

        /**
         * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/package-tree.html
         * Jerarquía de las excepciones: todas vienen de Throwable, que se extiende en
         * Error y Exception. Error son las
         * que nos comemos, así que hay que dejar que ocurran. La clase Exception tiene
         * a su vez
         * muchas subclases, y hayq ue distinguir entre RuntimeException (esta clase y
         * todas sus subclases son las UNCHECKED)
         * y el resto de subclases (Exception y esas otras subclases son las CHECKED)
         */

        /* MANEJO DE EXCEPCIONES */

        /*
         * Hay que entender cómo funciona java --> el programa siempre entre por el
         * main, y el main
         * se irá encargando de llamar a otros métodos, y esos métodos a otro métodos,
         * etc. Eso se llama la pila de
         * llamadas (call stack). Si el program funciona bien, todos los métodos
         * ejecutarán sin problema y el programa
         * termina.
         * Sin embargo, si en ejecución ocurre una excepción, la excepción se lanza
         * (throw) desde el método que la crea
         * hacia arriba en la pila de llamadas hasta que, o bien en algún sitio se
         * maneje (handle), o bien el programa explote
         * (termine lanzando un error).
         * 
         * En general tenemos que distinguir 2 tipos de comportamiento según las
         * excepciones sean CHECKED o UNCHECKED.
         * Como las CHECKED estamos obligados a manejarlas, lo que queremos es que
         * anteuna exception checked el
         * programa termine amablemente, o tome otras acciones, pero que no explote en
         * la cara.
         * 
         * Las UNCHEKED (excepciones en runtime) NO queremos que ocurran, y sí es
         * conveniente que nos
         * explote el programa en la cara, para que sepamos que hay un error de
         * programación que hay que
         * corregir. También, a veces, queremos nosotros mismos lanzar este tipo de
         * excepciones cuando alguien que vaya a usar nuestro programa lo esté usando
         * de mala manera, para advertirle de que tiene que hacer las cosas bien.
         * El ejemplo claro que ya se ha visto es el IndexOutOfBounds. Estás intentando
         * usar la clase arrays mal, y entonces te lanza una excepcion. Es tu problema
         * que no te lanze esa excepción, haz el código bien, no pongas un try-catch
         * 
         */

        /**
         * para manejar las excepciones usamos los bloques try-catch-finally, ver
         * ejemplos concretos en
         * las otras clases que hago
         */

        // CheckedExceptionHandling.leerFichero_v3();
        // CheckedExceptionHandling.leerFichero_v4();
        // System.out.println("el programa sigue");

        // esto me dice que unhandled exception, porque el método pasa el marrón a otro
        // método que lo llame
        // CheckedExceptionHandling.leerFichero_v6();

        // aunque un método pueda lanzar una excecpión, si esta no ocurre, no se lanza
        // String str = "asd";
        // System.out.println(UncheckedExceptionHandling.stringLength_v3(str));

        // String str = null;
        // System.out.println(UncheckedExceptionHandling.stringLength_v3(str));
        // System.out.println("Si se lanza la excepción y no la manejasmo, el programa
        // explota. Esta linea no se ejecuta");

        // si manejamos la exception, el programa finaliza bien
        // String str = null;
        // try {
        //     System.out.println(UncheckedExceptionHandling.stringLength_v3(str));
        // } catch (NullPointerException npe) {
        //     System.out.println("Excepción pillada");
        // }
        // System.out.println("Si se lanza la excepción y no la manejasmo, el programa explota. Esta linea SI se ejecuta");

    }

    public static void metodo(String texto) {
        System.out.println(texto.toUpperCase());
    }
}
