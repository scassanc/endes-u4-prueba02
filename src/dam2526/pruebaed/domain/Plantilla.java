package dam2526.pruebaed.domain;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {
  private List<Empleado> empleados;

  public Plantilla() {
    empleados = new ArrayList<>();
  }

  public void agregarEmpleado(Empleado empleado) {
    empleados.add(empleado);
  }

  public List<Empleado> getEmpleadosPorNombre(String filtroNombre) {
    List<Empleado> empleadosFiltrados = new ArrayList<>();

    for (Empleado empleado : empleados) {
      if (empleado.getNombre().contains(filtroNombre) || empleado.getApellidos().contains(filtroNombre)) {
        empleadosFiltrados.add(empleado);
      }
    }

    return empleadosFiltrados;
  }
}
