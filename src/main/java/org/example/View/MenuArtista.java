package org.example.View;

import org.bson.Document;
import org.example.Controller.ArtistaController;
import org.example.Entity.Artista;
import org.example.Entity.Genero;

import java.util.List;

public class MenuArtista {
    public static void menuArtista() {

        int opcion = 0;

        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Crear artista");
            System.out.println("2. Modificar artista");
            System.out.println("3. Eliminar artista");
            System.out.println("4. Buscar artista");
            System.out.println("5. Listar todos los artistas");
            System.out.println("6. Volver");
            opcion = new java.util.Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    MenuArtista.menuCrearArtista();
                    break;
                case 2:
                    MenuArtista.menuModificarArtista();
                    break;
                case 3:
                    MenuArtista.menuEliminarArtista();
                    break;
                case 4:
                    MenuArtista.menuConsultarArtista();
                    break;
                case 5:
                    MenuArtista.menuListarArtistas();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    private static void menuEliminarArtista() {
        System.out.println("Ingrese el nombre del artista que desea eliminar");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();

        ArtistaController artistaController = new ArtistaController();
        Artista artistaEncontrado = artistaController.findArtista(nombreArtista);
        if(artistaEncontrado == null) {
            System.out.println("No se encontró el artista");
            return;
        }
        artistaController.deleteArtista(artistaEncontrado);

        System.out.println("Artista eliminado con éxito");
    }

    private static void menuCrearArtista() {
        System.out.println("Ingrese el nombre del artista");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();
        System.out.println("Ingrese el genero del artista");
        String generoString = new java.util.Scanner(System.in).nextLine();

        Genero genero = new Genero(generoString);
        Artista artista = new Artista(nombreArtista, genero);

        ArtistaController artistaController = new ArtistaController();
        artistaController.insertArtista(artista);

        System.out.println("Artista creado con éxito");
    }

    public static void menuModificarArtista() {
        System.out.println("Ingrese el nombre del artista que desea modificar");
        String nombreArtista = new java.util.Scanner(System.in).nextLine();
        ArtistaController artistaController = new ArtistaController();
        Artista artistaEncontrado = artistaController.findArtista(nombreArtista);
        if(artistaEncontrado == null) {
            System.out.println("No se encontró el artista");
            return;
        }
        System.out.println("Artista encontrado:");
        System.out.println(artistaEncontrado);

        int opcion = 0;
        System.out.println("1. Modificar nombre");
        System.out.println("2. Modificar genero");
        System.out.println("3. Volver");
        opcion = new java.util.Scanner(System.in).nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nuevo nombre del artista");
                String nuevoNombre = new java.util.Scanner(System.in).nextLine();

                Document update = new Document("$set", new Document("nombre", nuevoNombre));

                artistaController.updateArtista(new Document("nombre", nombreArtista), update);
                System.out.println("Artista modificado con éxito");
                break;
            case 2:
                System.out.println("Ingrese el nuevo genero del artista");
                String nuevoGenero = new java.util.Scanner(System.in).nextLine();

                Document artist2 = new Document("nombre", nombreArtista);
                artist2.append("genero", artistaEncontrado.getGenero().getNombre());

                Document update2 = new Document("nombre", nombreArtista);
                update2.append("genero", nuevoGenero);

                artistaController.updateArtista(artist2, update2);
                System.out.println("Artista modificado con éxito");
                break;
            case 3:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public static void menuConsultarArtista() {
        int opcion = 0;
        System.out.println("1. Consultar por nombre");
        System.out.println("2. Consultar por genero");
        System.out.println("3. Volver");
        opcion = new java.util.Scanner(System.in).nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre del artista que desea buscar");
                String nombreArtista = new java.util.Scanner(System.in).nextLine();
                ArtistaController artistaController = new ArtistaController();
                Document filter = new Document("nombre", nombreArtista);

                artistaController.findArtista(filter);

                break;
            case 2:
                System.out.println("Ingrese el genero del artista que desea buscar");
                String generoArtista = new java.util.Scanner(System.in).nextLine();
                ArtistaController artistaController2 = new ArtistaController();
                List<Artista> artistasPorGenero = artistaController2.findArtistasByGenero(generoArtista);
                artistasPorGenero.forEach(System.out::println);
                break;
            case 3:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public static void menuListarArtistas() {
        ArtistaController artistaController = new ArtistaController();
        artistaController.showAllArtistas();
    }
}
