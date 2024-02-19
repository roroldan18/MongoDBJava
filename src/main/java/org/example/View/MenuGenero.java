package org.example.View;

import org.bson.Document;
import org.example.Controller.GeneroController;
import org.example.Entity.Genero;

public class MenuGenero {
    public static void mostrarMenu() {
        int opcion = 0;
        System.out.println("1. Insertar género");
        System.out.println("2. Modificar género");
        System.out.println("3. Eliminar género");
        System.out.println("4. Mostrar géneros");
        System.out.println("5. Buscar género");
        System.out.println("6. Eliminar todos los géneros");
        System.out.println("7. Volver al menú principal");

        do {
            opcion = new java.util.Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    menuInsertarGenero();
                    break;
                case 2:
                    menuModificarGenero();
                    break;
                case 3:
                    menuEliminarGenero();
                    break;
                case 4:
                    menuMostrarGeneros();
                    break;
                case 5:
                    menuBuscarGenero();
                    break;
                case 6:
                    menuEliminarTodo();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 7);
    }

    private static void menuEliminarTodo() {
        System.out.println("¿Está seguro que desea eliminar todos los géneros? (s/n)");
        String respuesta = new java.util.Scanner(System.in).nextLine();
        if(respuesta.equals("s")) {
            GeneroController generoController = new GeneroController();
            generoController.deleteAllGeneros();
            System.out.println("Todos los géneros han sido eliminados");
        }
    }

    private static void menuBuscarGenero() {
        System.out.println("Ingrese el nombre del género");
        String nombreGenero = new java.util.Scanner(System.in).nextLine();
        GeneroController generoController = new GeneroController();
        Document filter = new Document("nombre", nombreGenero);
        generoController.findGenero(filter);
    }

    private static void menuMostrarGeneros() {
        GeneroController generoController = new GeneroController();
        generoController.showAllGeneros();
    }

    private static void menuEliminarGenero() {
        System.out.println("Ingrese el nombre del género que desea eliminar");
        String nombreGenero = new java.util.Scanner(System.in).nextLine();
        GeneroController generoController = new GeneroController();
        Document filter = new Document("nombre", nombreGenero);
        generoController.deleteGenero(filter);
        System.out.println("Género eliminado");
    }

    private static void menuModificarGenero() {
        System.out.println("Ingrese el nombre del género que desea modificar");
        String nombreGenero = new java.util.Scanner(System.in).nextLine();
        System.out.println("Ingrese el nuevo nombre del género");
        String nuevoNombreGenero = new java.util.Scanner(System.in).nextLine();
        GeneroController generoController = new GeneroController();
        Document filter = new Document("nombre", nombreGenero);
        Document update = new Document("nombre", nuevoNombreGenero);
        generoController.updateGenero(filter, update);
        System.out.println("Género modificado");
    }

    private static void menuInsertarGenero() {
        System.out.println("Ingrese el nombre del género");
        String nombreGenero = new java.util.Scanner(System.in).nextLine();
        Genero genero = new Genero(nombreGenero);
        GeneroController generoController = new GeneroController();
        generoController.insertGenero(genero);
        System.out.println("Género insertado");
    }
}
