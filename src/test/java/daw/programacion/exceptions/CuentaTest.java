package daw.programacion.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CuentaTest {

    // ojo que este método (assertThrows) solo está para JUnit 5.*
    @Test
    public void meterDineroNegativoDaIllegalArgumentException() {
        Cuenta cuenta = new Cuenta("asd", "aa");
        double dineroNegativo = -6.5;
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cuenta.meterDinero(dineroNegativo);
                });

    }

    /*
     * Ya de paso, tests parametrizados. Sirven para lanzar un mismo test con
     * diferentes argumentos, así
     * me ahorro escribir código.
     * Necesitamos añadir una nueva dependencia en pom.xml: junit-jupiter-params
     * Ponemos las anotaciones @ParametrizedTest, para que se sepa que es
     * paramétrico, y
     * 
     * @ValueSource para meter los argumentos. Los argumentos serán de un tipo, se
     * pone
     * doubles/ints/strings...
     * Ahora, en los parámetros del metodo de test, si que se come un argumento, los
     * ValueSource
     */

    @ParameterizedTest
    @ValueSource(doubles = { 5, 10, 15 })
    public void meterDineroFuncionaBien(double cantidad) {
        Cuenta cuenta = new Cuenta("asd", "aa");
        assertTrue(cantidad == cuenta.meterDinero(cantidad));
    }

    /* si queremos pasar varios parámetros, entonces usamos esta anotación */
    @ParameterizedTest
    @CsvSource({ "20,10,2" })
    public void testDivision(double num1, double num2, double esperado) {
        assertEquals(Cuenta.dividir(num1, num2), esperado);
    }

    /*
     * si queremos pasar varios parámetros varias veces, es así, entonces usamos
     * esta anotación
     */
    @ParameterizedTest
    @CsvSource({ "20,10,2",
                "15,3,5" })
    public void testDivision2(double num1, double num2, double esperado) {
        assertEquals(Cuenta.dividir(num1, num2), esperado);
    }
}
