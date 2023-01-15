package daw.programacion.exceptions;

public class UncheckedExceptionHandling {
    /*
     * Las exception unchecked son también conocidas como Runtime exception.
     * Es porque te explota el programa mientras corre. A diferencia de
     * las checked, las cuales el compilador nos obliga a manejar (handle)
     * las unchecked NO deberían ocurrir. Son, en general, errores de programación
     * o bugs.
     * 
     */

    // este método podría tener lanzar una excepción, si el parámetro que se le pasa
    // es null
    public static int stringLength(String string) {
        return string.length();
    }

    /*
     * Podríamos manejar esa excecpión, pero lo que realmente hay que hacer es
     * evitar que courra, programando bien
     * y haciendo tests
     */

    // el mismo metodo de antes pero manejamos la excepción directamente
    public static int stringLength_v2(String string) {
        try {
            return string.length();
        } catch (NullPointerException npe) {
            npe.getStackTrace();
            System.out.println("No se puede pasar un parámetro NULL");
        }
        return -1;
    }

    // el mismo metodo de antes pero dejamos que el método que llame a este método
    // (u otro por encima en la jerarquía de llamadas) se encargue de manejar la
    // excepción
    public static int stringLength_v3(String string) throws NullPointerException {
        return string.length();
    }

}
