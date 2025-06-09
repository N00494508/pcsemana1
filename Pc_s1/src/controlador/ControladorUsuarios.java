package controlador;

import java.util.*;

import modelo.Usuario;

public class ControladorUsuarios {

	public static double calcularPromedioEdad(ArrayList<Usuario> usuarios) {
        int suma = 0;
        for (Usuario u : usuarios) {
            suma += u.getEdad();
        }
        return usuarios.size() > 0 ? (double) suma / usuarios.size() : 0;
    }

    public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    public static ArrayList<Usuario> buscarUsuarioPorCiudad(ArrayList<Usuario> usuarios, String ciudad) {
        ArrayList<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    public static Usuario elegirUsuarioDestacado(ArrayList<Usuario> usuarios) {
        if (usuarios.isEmpty()) return null;
        Random rand = new Random();
        int index = rand.nextInt(usuarios.size());
        return usuarios.get(index);
    }

    public static class Texto {
        public static void mostrarEncabezado(String titulo) {
            System.out.println("==== " + titulo + " ====");
        }
    }
}
