package dam2526.pruebaed.app;

import dam2526.pruebaed.domain.GestorEmpleados;
import dam2526.pruebaed.domain.Plantilla;
import dam2526.pruebaed.utils.Consola;
import dam2526.pruebaed.utils.IEntradaSalida;

public class Main {
  public static void main(String[] args) {
    IEntradaSalida consola = new Consola();
    Plantilla plantilla = new Plantilla();
    GestorEmpleados gestorEmpleados = new GestorEmpleados(plantilla, consola);

    gestorEmpleados.ejecutar();
  }
}
