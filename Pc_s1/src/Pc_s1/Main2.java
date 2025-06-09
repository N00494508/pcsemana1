package Pc_s1;

import java.util.*;
import modelo.Figura;
import modelo.Circulo;
import modelo.Rectangulo;
import modelo.Triangulo;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ArrayList<Double> historial = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Círculo\n2. Rectángulo\n3. Triángulo\n4. Salir");
            System.out.print("Elige una figura: ");
            int opcion = scanner.nextInt();

            Figura figura = null;

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Radio: ");
                        double radio = scanner.nextDouble();
                        if (radio <= 0) throw new IllegalArgumentException();
                        figura = new Circulo(radio);
                        break;
                    case 2:
                        System.out.print("Base: ");
                        double baseR = scanner.nextDouble();
                        System.out.print("Altura: ");
                        double alturaR = scanner.nextDouble();
                        if (baseR <= 0 || alturaR <= 0) throw new IllegalArgumentException();
                        figura = new Rectangulo(baseR, alturaR);
                        break;
                    case 3:
                        System.out.print("Base: ");
                        double baseT = scanner.nextDouble();
                        System.out.print("Altura: ");
                        double alturaT = scanner.nextDouble();
                        if (baseT <= 0 || alturaT <= 0) throw new IllegalArgumentException();
                        figura = new Triangulo(baseT, alturaT);
                        break;
                    case 4:
                        continuar = false;
                        continue;
                    default:
                        System.out.println("Opción inválida.");
                        continue;
                }

                double area = figura.calcularArea();
                historial.add(area);
                System.out.printf("Área calculada: %.2f\n", area);

            } catch (Exception e) {
                System.out.println("Datos inválidos.");
                scanner.nextLine(); // limpiar buffer
            }
        }

        System.out.println("Historial de áreas:");
        for (double area : historial) {
            System.out.printf("- %.2f\n", area);
        }

        System.out.println("Total figuras: " + historial.size());
        double promedio = historial.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.printf("Promedio de áreas: %.2f\n", promedio);
    }

}
