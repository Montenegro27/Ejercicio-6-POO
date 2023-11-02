// Universidad del Valle de Guatemala - POO - 10
// Mauricio Enrique Montenegro Gonzalez - 23679
// Ejercicio 6
// Interfaz para definir métodos comunes a todos los dispositivos electrónicos
interface DispositivoElectronico {
    void encender();

    void apagar();

    boolean validarEncendido();
}

// Clase Telefono que implementa DispositivoElectronico
class Telefono implements DispositivoElectronico {
    private String modelo;
    private boolean encendido;

    public Telefono(String modelo) {
        this.modelo = modelo;
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

    public String getModelo() {
        return modelo;
    }
}
