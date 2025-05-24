import java.util.Random;
import java.util.Scanner;

class Laberinto {
    
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void contarParesMayoresA4(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula");
        }
        try {
            int contador = 0;
            for (int[] fila : matriz) {
                if (fila == null) {
                    throw new IllegalArgumentException("Una fila de la matriz es nula");
                }
                for (int valor : fila) {
                    if (valor % 2 == 0 && valor > 4) {
                        contador++;
                    }
                }
            }
            System.out.println("\n1. Cantidad de números pares mayores a 4: " + contador);
        } catch (Exception e) {
            System.out.println("Error al contar números pares mayores a 4: " + e.getMessage());
        }
    }

    public static void calcularPromedioImpares(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula");
        }
        try {
            int suma = 0;
            int contador = 0;
            for (int[] fila : matriz) {
                if (fila == null) {
                    throw new IllegalArgumentException("Una fila de la matriz es nula");
                }
                for (int valor : fila) {
                    if (valor % 2 != 0) {
                        suma += valor;
                        contador++;
                    }
                }
            }
            double promedio = contador > 0 ? (double) suma / contador : 0;
            System.out.println("2. Promedio de números impares: " + String.format("%.2f", promedio));
        } catch (Exception e) {
            System.out.println("Error al calcular el promedio de impares: " + e.getMessage());
        }
    }

    public static void calcularSumaFilas(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula");
        }
        try {
            System.out.println("3. Suma de valores por fila:");
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i] == null) {
                    throw new IllegalArgumentException("La fila " + i + " es nula");
                }
                int suma = 0;
                for (int valor : matriz[i]) {
                    suma += valor;
                }
                System.out.println("   Fila " + (i + 1) + ": " + suma);
            }
        } catch (Exception e) {
            System.out.println("Error al calcular la suma de filas: " + e.getMessage());
        }
    }

    public static void encontrarMayorNumero(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0] == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula o vacía");
        }
        try {
            int mayor = matriz[0][0];
            int filaMayor = 0;
            int colMayor = 0;

            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i] == null) {
                    throw new IllegalArgumentException("La fila " + i + " es nula");
                }
                for (int j = 0; j < matriz[i].length; j++) {
                    if (matriz[i][j] > mayor) {
                        mayor = matriz[i][j];
                        filaMayor = i;
                        colMayor = j;
                    }
                }
            }
            System.out.println("4. El número mayor es " + mayor + " y se encuentra en la posición [" + filaMayor + "][" + colMayor + "]");
        } catch (Exception e) {
            System.out.println("Error al encontrar el número mayor: " + e.getMessage());
        }
    }
}

public class LaberintoUniversitario {

    public static void main(String[] args) {
        int[][] laberinto = null;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        try {
            laberinto = new int[5][5];
            try {
                for (int fila = 0; fila < laberinto.length; fila++) {
                    for (int col = 0; col < laberinto[fila].length; col++) {
                        laberinto[fila][col] = random.nextInt(9) + 1;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al generar el laberinto: " + e.getMessage());
                return;
            }

            System.out.println("=== LABERINTO UNIVERSITARIO ===");
            Laberinto.mostrarMatriz(laberinto);

            System.out.println("\n¡Bienvenido al Laberinto Universitario!");
            System.out.println("Este sistema representa los pasillos secretos de tu facultad.");
            System.out.println("Cada número indica un nivel de energía en ese punto.");
            System.out.println("Tu misión es explorar este laberinto cumpliendo los siguientes desafíos:");
            System.out.println();
            System.out.println("1. Contar cuántos números pares hay mayores a 4. ⚡");
            System.out.println("2. Calcular el promedio de los números impares. 🎯");
            System.out.println("3. Calcular la suma de los valores de cada fila. 🧮");
            System.out.println("4. BONUS: Encuentra la posición del mayor número del laberinto. 👑");

            System.out.println("\n-----Resultado de los secretos de la facultad-----");
            Laberinto.contarParesMayoresA4(laberinto);
            Laberinto.calcularPromedioImpares(laberinto);
            Laberinto.calcularSumaFilas(laberinto);
            Laberinto.encontrarMayorNumero(laberinto);

        } catch (Exception e) {
            System.out.println("Error inesperado en el programa: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}