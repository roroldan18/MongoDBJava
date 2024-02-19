package org.example.View;

import org.example.Controller.ArtistaController;
import org.example.Controller.EscuchasMensualesController;
import org.example.Controller.Util;
import org.example.Entity.Artista;
import org.example.Entity.EscuchasMensuales;

public class MenuEscuchas {

    public static void mostrarMenu() {
        int opcion = 0;
        System.out.println("1. Insertar escucha");
        System.out.println("2. Modificar escucha");
        System.out.println("3. Eliminar escucha");
        System.out.println("4. Mostrar escuchas");
        System.out.println("5. Buscar escucha");
        System.out.println("6. Eliminar todas las escuchas");
        System.out.println("7. Volver al menú principal");

        opcion = new java.util.Scanner(System.in).nextInt();
        switch (opcion) {
            case 1:
                MenuEscuchas.menuInsertarEscucha();
                break;
            case 2:
                MenuEscuchas.menuModificarEscucha();
                break;
            case 3:
                MenuEscuchas.menuEliminarEscucha();
                break;
            case 4:
                MenuEscuchas.menuMostrarEscuchas();
                break;
            case 5:
                MenuEscuchas.menuBuscarEscucha();
                break;
            case 6:
                MenuEscuchas.menuEliminarTodasLasEscuchas();
                break;
            case 7:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    private static void menuEliminarTodasLasEscuchas() {
        System.out.println("¿Está seguro que desea eliminar todas las escuchas? (s/n)");
        String respuesta = new java.util.Scanner(System.in).nextLine();
        if(respuesta.equals("s")) {
            EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
            escuchasMensualesController.deleteAllEscuchasMensuales();
            System.out.println("Todas las escuchas han sido eliminadas");
        }
    }

    private static void menuBuscarEscucha() {
        int opcion = 0;
        System.out.println("1. Buscar por artista");
        System.out.println("2. Buscar por mes");
        System.out.println("3. Volver");
        opcion = new java.util.Scanner(System.in).nextInt();
        switch (opcion) {
            case 1:
                MenuEscuchas.menuBuscarPorArtista();
                break;
            case 2:
                MenuEscuchas.menuBuscarPorMes();
                break;
            case 3:
                MenuEscuchas.mostrarMenu();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    private static void menuBuscarPorMes() {
        System.out.println("Ingrese el mes que desea buscar");
        String mes = new java.util.Scanner(System.in).nextLine();
        EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
        escuchasMensualesController.findEscuchasMensuales(new org.bson.Document("mes", mes));
    }

    private static void menuBuscarPorArtista() {
        System.out.println("Ingrese el nombre del artista que desea buscar");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();
        EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
        escuchasMensualesController.findEscuchasMensuales(new org.bson.Document("artista.nombre", nombreArtista));
    }

    private static void menuMostrarEscuchas() {
        EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
        escuchasMensualesController.showAllEscuchasMensuales();
    }

    private static void menuEliminarEscucha() {
        //Buscar escucha
        System.out.println("Ingrese el nombre del artista que desea eliminar");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();
        System.out.println("Ingrese el mes que desea eliminar");
        String mes = new java.util.Scanner(System.in).nextLine();
        EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
        escuchasMensualesController.deleteEscuchasMensuales(new org.bson.Document("artista.nombre", nombreArtista).append("mes", mes));
        System.out.println("Escucha eliminada");
    }

    private static void menuModificarEscucha() {

        System.out.println("Ingrese el nombre del artista que desea modificar");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();
        System.out.println("Ingrese el mes que desea modificar");
        String mes = new java.util.Scanner(System.in).nextLine();

        // TODO:Validaciones si el artista y el mes existen

        System.out.println("Ingrese la cantidad de escuchas");
        int escuchas = new java.util.Scanner(System.in).nextInt();
        EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
        escuchasMensualesController.updateEscuchasMensuales(new org.bson.Document("artista.nombre", nombreArtista).append("mes", mes), new org.bson.Document("escuchas", escuchas));
        System.out.println("Escucha modificada");
    }

    private static void menuInsertarEscucha() {
        System.out.println("Ingrese el nombre del artista");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();
        ArtistaController artistaController = new ArtistaController();
        Artista artista = artistaController.findArtista(nombreArtista);
        if (artista == null) {
            System.out.println("El artista no existe");
            return;
        }

        System.out.println("Ingrese el mes");
        String mes = new java.util.Scanner(System.in).nextLine();
        // Convertir mes a String
        int mesInt = Util.convertirMes(mes);
        if (mesInt == -1) {
            System.out.println("Mes inválido");
            return;
        }
        System.out.println("Ingrese la cantidad de escuchas");
        int escuchas = new java.util.Scanner(System.in).nextInt();
        EscuchasMensualesController escuchasMensualesController = new EscuchasMensualesController();
        escuchasMensualesController.insertEscuchasMensuales(new EscuchasMensuales(artista, mesInt, escuchas));
        System.out.println("Escucha insertada");
    }


}
