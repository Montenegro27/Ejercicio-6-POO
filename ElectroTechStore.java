// Universidad del Valle de Guatemala - POO - 10
// Mauricio Enrique Montenegro Gonzalez - 23679
// Ejercicio 6
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase ElectroTechStore para administrar dispositivos
class ElectroTechStore {
    private List<DispositivoElectronico> dispositivos;

    public ElectroTechStore() {
        dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(DispositivoElectronico dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void mostrarInformacion() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            System.out.println("Tipo: " + dispositivo.getClass().getSimpleName());
            if (dispositivo instanceof Telefono) {
                Telefono telefono = (Telefono) dispositivo;
                System.out.println("Modelo: " + telefono.getModelo());
            } else if (dispositivo instanceof Computadora) {
                Computadora computadora = (Computadora) dispositivo;
                System.out.println("Marca: " + computadora.getMarca());
            }
            System.out.println("Encendido: " + dispositivo.validarEncendido());
            System.out.println();
        }
    }

    public void validarElementosEncendidos() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            System.out.println("Tipo: " + dispositivo.getClass().getSimpleName());
            System.out.println("Encendido: " + dispositivo.validarEncendido());
            System.out.println();
        }
    }

    public void guardarEnCSV(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (DispositivoElectronico dispositivo : dispositivos) {
                if (dispositivo instanceof Telefono) {
                    Telefono telefono = (Telefono) dispositivo;
                    writer.println("Telefono|" + telefono.getModelo() + "|" + telefono.validarEncendido());
                } else if (dispositivo instanceof Computadora) {
                    Computadora computadora = (Computadora) dispositivo;
                    writer.println("Computadora|" + computadora.getMarca() + "|" + computadora.validarEncendido());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeCSV(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length == 3) {
                    String tipo = datos[0];
                    String atributo = datos[1];
                    boolean encendido = Boolean.parseBoolean(datos[2]);

                    if (tipo.equals("Telefono")) {
                        Telefono telefono = new Telefono(atributo);
                        if (encendido) {
                            telefono.encender();
                        }
                        dispositivos.add(telefono);
                    } else if (tipo.equals("Computadora")) {
                        Computadora computadora = new Computadora(atributo);
                        if (encendido) {
                            computadora.encender();
                        }
                        dispositivos.add(computadora);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


