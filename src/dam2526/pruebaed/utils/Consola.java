package dam2526.pruebaed.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola implements IEntradaSalida {
  private Scanner sc;

  public Consola() {
    sc = new Scanner(System.in);
  }

  @Override
  public void imprimir(String texto) {
    System.out.print(texto);
  }

  @Override
  public void imprimirLinea(String texto) {
    System.out.println(texto);
  }

  @Override
  public String leerTexto(String mensaje) {
    imprimir(mensaje);
    return sc.nextLine();
  }

  @Override
  public int leerEntero(String mensaje) {
    int numero = 0;
    boolean esValido = false;

    do {
      try {
        imprimir(mensaje);
        numero = sc.nextInt();
        sc.nextLine();
        esValido = true;
      } catch (InputMismatchException error) {
        sc.nextLine();
        imprimir("[ERROR] ");
      }
    } while (!esValido);

    return numero;
  }

  @Override
  public double leerImporte(String mensaje) {
    double numero = 0;
    boolean esValido = false;

    do {
      try {
        imprimir(mensaje);
        numero = sc.nextDouble();
        sc.nextLine();
        esValido = true;
      } catch (InputMismatchException error) {
        sc.nextLine();
        imprimir("[ERROR] ");
      }
    } while (!esValido);

    return numero;
  }

  @Override
  public void mostrarMenu() {
    imprimirLinea("1 - Contratar empleado");
    imprimirLinea("2 - Listar todos los empleados");
    imprimirLinea("3 - Listar empleados con filtro");
    imprimirLinea("4 - Salir");
  }

  @Override
  public void limpiarPantalla() {
    imprimir("\n".repeat(50));
  }

  @Override
  public void pausa() {
    leerTexto("Pulse una tecla para continuar...");
  }
}
