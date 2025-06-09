package Pc_s1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import controlador.ControladorUsuarios;
import modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        while (true) {
            ControladorUsuarios.Texto.mostrarEncabezado("Registro de Usuario");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            int edad = 0;
            while (true) {
                try {
                    System.out.print("Edad: ");
                    edad = Integer.parseInt(scanner.nextLine());
                    if (edad < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Edad no válida. Intente de nuevo.");
                }
            }

            System.out.print("Ciudad: ");
            String ciudad = scanner.nextLine();

            usuarios.add(new Usuario(nombre, edad, ciudad));

            System.out.print("¿Deseas agregar otro usuario? (s/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("s")) break;
        }

        ControladorUsuarios.Texto.mostrarEncabezado("Estadísticas");
        System.out.println("Total de usuarios: " + usuarios.size());
        System.out.printf("Promedio de edad: %.2f\n", ControladorUsuarios.calcularPromedioEdad(usuarios));

        String nombreMasLargo = usuarios.stream().max(Comparator.comparingInt(u -> u.getNombre().length())).get().getNombre();
        System.out.println("Nombre más largo: " + nombreMasLargo);

        Usuario destacado = ControladorUsuarios.elegirUsuarioDestacado(usuarios);
        if (destacado != null) {
            System.out.println("Usuario destacado: " + destacado.getNombre() + " de " + destacado.getCiudad());
        }
    }
}
