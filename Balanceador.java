class Servidor {
    String nombre;
    int peso;
    int conexiones;

    Servidor(String nombre, int peso, int conexiones) {
        this.nombre = nombre;
        this.peso = peso;
        this.conexiones = conexiones;
    }

    double carga() {
        return (double) conexiones / peso;
    }
}

public class Balanceador {

    public static Servidor seleccionarServidor(Servidor[] servidores) {
        Servidor seleccionado = servidores[0];

        for (Servidor servidor : servidores) {
            if (servidor.carga() < seleccionado.carga()) {
                seleccionado = servidor;
            }
        }

        seleccionado.conexiones++;
        return seleccionado;
    }

    public static void main(String[] args) {

        Servidor[] servidores = {
            new Servidor("Servidor 1", 2, 3),
            new Servidor("Servidor 2", 1, 5),
            new Servidor("Servidor 3", 1, 2)
        };

        Servidor seleccionado = seleccionarServidor(servidores);

        System.out.println(
            "Nueva conexión asignada a: " + seleccionado.nombre
        );

        for (Servidor servidor : servidores) {
            System.out.println(
                servidor.nombre +
                " - Peso: " + servidor.peso +
                " - Conexiones: " + servidor.conexiones
            );
        }
    }
}