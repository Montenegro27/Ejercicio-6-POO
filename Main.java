// Universidad del Valle de Guatemala - POO - 10
// Mauricio Enrique Montenegro Gonzalez - 23679
// Ejercicio 6
public class Main {
    public static void main(String[] args) {
        ElectroTechStore tienda = new ElectroTechStore();

        Telefono telefono1 = new Telefono("Modelo1");
        Computadora computadora1 = new Computadora("Marca1");

        telefono1.encender();
        tienda.agregarDispositivo(telefono1);
        tienda.agregarDispositivo(computadora1);

        tienda.mostrarInformacion();

        tienda.validarElementosEncendidos();

        tienda.guardarEnCSV("dispositivos.csv");
        tienda.cargarDesdeCSV("dispositivos.csv");
    }
}