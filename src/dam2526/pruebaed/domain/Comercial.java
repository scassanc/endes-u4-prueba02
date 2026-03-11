package dam2526.pruebaed.domain;

public class Comercial extends Empleado {
  private double ventas;

  public Comercial(String dni, String nombre, String apellidos, double sueldoBase) {
    super(dni, nombre, apellidos, sueldoBase);
    ventas = 0;
  }

  public void setVentas(double ventas) {
    this.ventas = ventas;
  }

  @Override
  public double getSueldo() {
    return sueldoBase + ventas * 0.1;
  }
}
