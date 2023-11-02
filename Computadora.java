// Universidad del Valle de Guatemala - POO - 10
// Mauricio Enrique Montenegro Gonzalez - 23679
// Ejercicio 6
// Clase Computadora que implementa DispositivoElectronico
class Computadora implements DispositivoElectronico {
    private String marca;
    private boolean encendido;

    public Computadora(String marca) {
        this.marca = marca;
        this.encendido = false;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public boolean validarEncendido() {
        return encendido;
    }

    public String getMarca() {
        return marca;
    }
}
