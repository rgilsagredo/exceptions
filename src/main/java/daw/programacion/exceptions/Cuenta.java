package daw.programacion.exceptions;

public class Cuenta {

    private String id;
    private String nombre;
    private double saldo = 0.0;

    public Cuenta(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Cuenta(String id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    /*
     * En este ejemplo, queremos prevenir que uestro código se use mal. Igual que la
     * clase array te
     * explota si intentas acceder a un elemento que no existe (estás usando el
     * código mal), aquí querríamos
     * prevenir que se meta dinero negativo (no tiene sentido). Así que metemos una
     * exception en el método.
     * La que nos conviene en este caso es IllegalArgument, pero en general hay que
     * buscar qué es lo que más se ajusta a tus necesidades.
     * No hay nada bien ni mal, se trata de dar la mejor solución al comprtameinto
     * que deseas.
     */
    public double meterDinero(double cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException();
        } // en otro caso, se añade el dinero a la cuenta
        this.saldo += cantidad;
        return this.saldo;
    }

    public double sacarDinero(double cantidad) {
        if (cantidad <= this.saldo) {
            this.saldo -= cantidad;
        } else {
            System.out.println("No hay saldo suficiente"); // cambiar por exceptios??
        }

        return this.saldo;
    }

    public double transferirACuenta(Cuenta cuenta, double cantidad) {
        double saldoActual = this.saldo;
        this.sacarDinero(cantidad);

        if (this.saldo != saldoActual) {
            cuenta.meterDinero(cantidad);
        } else {
            System.out.println("No se puede hacer la transferencia");
        }

        return this.saldo;
    }

    // añado un método moñas para hacer cosas de tests parametrizados
    public static double dividir(double numero1, double numero2) throws ArithmeticException {
        if (numero2 == 0) {
            throw new ArithmeticException();
        }
        return numero1 / numero2;
    }

    @Override
    public String toString() {
        return "Cuenta [id=" + id + ", nombre=" + nombre + ", saldo=" + saldo + "]";
    }

}