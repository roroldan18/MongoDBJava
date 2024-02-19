package org.example.View;

public class Menu {
    public static void mostrarPrincipal() {
        //Elegir con qué colección desea trabajar
        int opcion = 0;
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Menú Artistas");
            System.out.println("2. Menú Generos");
            System.out.println("3. Menú Escuchas Mensuales");
            System.out.println("4. Salir");
            opcion = new java.util.Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    MenuArtista.menuArtista();
                    break;
                case 2:
                    MenuGenero.mostrarMenu();
                    break;
                case 3:
                    MenuEscuchas.mostrarMenu();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);
    }
}
