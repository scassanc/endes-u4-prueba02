package dam2526.pruebaed.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dam2526.pruebaed.utils.IEntradaSalida;

public class GestorEmpleados {
  private Plantilla plantilla;
  private IEntradaSalida consola;

  public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {
    this.plantilla = plantilla;
    this.consola = consola;
  }

  public void ejecutar() {
    consola.limpiarPantalla();
    boolean continuar = true;

    while (continuar) {
      consola.mostrarMenu();
      int opcion;

      do {
        opcion = consola.leerEntero("> ");
      } while (opcion < 1 || opcion > 4);

      switch (opcion) {
        case 1: {
          contratarEmpleado();
          break;
        }
        case 2: {
          listarTodos();
          break;
        }
        case 3: {
          listarPorFiltro();
          break;
        }
        case 4: {
          continuar = false;
          break;
        }
      }
    }
  }

  private void contratarEmpleado() {
    consola.limpiarPantalla();
    consola.imprimirLinea("1 - Tecnico");
    consola.imprimirLinea("2 - Comercial");
    int opcion;

    do {
      opcion = consola.leerEntero("> ");
    } while (opcion < 1 || opcion > 2);

    consola.limpiarPantalla();
    String nombre = consola.leerTexto("Nombre: ");
    String apellidos = consola.leerTexto("Apellidos: ");
    String dni = consola.leerTexto("DNI: ");
    double sueldoBase = consola.leerImporte("Sueldo base: ");

    Empleado empleado = switch (opcion) {
      case 1 -> {
        int categoria = consola.leerEntero("Categoría: ");
        yield new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
      }
      case 2 -> {
        double ventas = consola.leerImporte("Ventas: ");
        Comercial comercial = new Comercial(dni, nombre, apellidos, sueldoBase);
        comercial.setVentas(ventas);
        yield comercial;
      }
      default -> null;
    };

    plantilla.agregarEmpleado(empleado);
    consola.limpiarPantalla();
  }

  private void listarTodos() {
    consola.limpiarPantalla();
    List<Empleado> empleados = plantilla.getEmpleadosPorNombre("");
    listarEmpleados(empleados);
  }

  private void listarPorFiltro() {
    consola.limpiarPantalla();
    String filtro = consola.leerTexto("Filtro: ");
    List<Empleado> empleados = plantilla.getEmpleadosPorNombre(filtro);
    listarEmpleados(empleados);
  }

  private void listarEmpleados(List<Empleado> empleados) {
    ordenarPorNombre(empleados);

    for (int indice = 0; indice < empleados.size(); indice++) {
      Empleado empleado = empleados.get(indice);
      consola.imprimirLinea(String.format("%d - %s %s: %f €", indice + 1, empleado.getNombre(), empleado.getApellidos(),
          empleado.getSueldo()));
    }

    consola.pausa();
    consola.limpiarPantalla();
  }

  private void ordenarPorNombre(List<Empleado> empleados) {
    Collections.sort(empleados, Comparator.comparing(Empleado::getNombre));
  }
}
