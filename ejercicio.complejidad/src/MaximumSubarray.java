import java.util.Random;

public class MaximumSubarray {

    public static void main(String[] args) {
        int N = 100000;

        /*Generamos una semilla para que cada vez que se ejecute el código
        se trabaje con los mismos datos, dándonos resultados homogéneos que
        son muy útiles al momento de comparar y verificar la complejidad
        de un algoritmo en condiciones controladas.
        */
        long SEED = 64125;

        System.out.println("==================================================");
        System.out.println("   ANÁLISIS DE COMPLEJIDAD: MAXIMUM SUBARRAY");
        System.out.println("==================================================");
        System.out.println("Generando " + N + " datos aleatorios (Seed: " + SEED + ")");

        // Generamos el arreglo una vez y lo usamos para ambos algoritmos.
        int[] datos = generarArregloConSemilla(N, SEED);

        System.out.println("Datos generados correctamente.\n");

        // --- EJECUCIÓN 1: SOLUCIÓN GENÉRICA (FUERZA BRUTA) ---
        System.out.println("Ejecutando Solución Genérica (Fuerza Bruta O(N^2))");

        long inicioBruta = System.nanoTime();
        int maxBruta = solucionFuerzaBruta(datos);
        long finBruta = System.nanoTime();

        double tiempoBruta = (finBruta - inicioBruta) / 1_000_000.0; // Convertir a ms

        System.out.println(" -> Resultado: " + maxBruta);
        System.out.printf(" -> Tiempo: %.4f ms\n\n", tiempoBruta);


        // --- EJECUCIÓN 2: SOLUCIÓN OPTIMIZADA (ALGORITMO DE KADANE) ---
        System.out.println("Ejecutando Solución Optimizada (Algoritmo de Kadane O(N))");

        long inicioKadane = System.nanoTime();
        int maxKadane = solucionKadane(datos);
        long finKadane = System.nanoTime();

        double tiempoKadane = (finKadane - inicioKadane) / 1_000_000.0; // Convertir a ms

        System.out.println(" -> Resultado: " + maxKadane);
        System.out.printf(" -> Tiempo: %.4f ms\n", tiempoKadane);

        // --- CONCLUSIONES ---
        System.out.println("==================================================");
        System.out.println("VERIFICACIÓN Y COMPARATIVA");

        if (maxBruta == maxKadane) {
            System.out.println("[OK] Ambos algoritmos llegaron al mismo resultado.");
        } else {
            System.out.println("[ERROR] Los resultados difieren. Revisar lógica.");
        }

        if (tiempoKadane > 0) {
            double mejora = tiempoBruta / tiempoKadane;
            System.out.printf("La solución optimizada fue %.2f veces más rápida.\n", mejora);
        } else {
            System.out.println("La solución optimizada fue tan rápida que el tiempo registrado es casi 0 ms.");
        }
        System.out.println("==================================================");
    }

    public static int solucionFuerzaBruta(int[] nums) {
        int maxTotal = Integer.MIN_VALUE;

        // Bucle i: Inicio del subarreglo
        for (int i = 0; i < nums.length; i++) {
            int sumaActual = 0;
            // Bucle j: Fin del subarreglo (se expande hacia la derecha)
            for (int j = i; j < nums.length; j++) {
                sumaActual += nums[j]; // Sumamos el nuevo elemento al acumulado

                if (sumaActual > maxTotal) {
                    maxTotal = sumaActual;
                }
            }
        }
        return maxTotal;
    }

    public static int solucionKadane(int[] nums) {
        // Validación por si el arreglo viene vacío
        if (nums == null || nums.length == 0) return 0;

        int maxTotal = nums[0];
        int sumaActual = nums[0];

        // Recorremos una sola vez
        for (int i = 1; i < nums.length; i++) {
            // Es mejor empezar de nuevo con el número actual (nums[i])
            // o sumarlo a la racha que ya traía (sumaActual + nums[i])?
            if (sumaActual + nums[i] > nums[i]) {
                sumaActual = sumaActual + nums[i];
            } else {
                sumaActual = nums[i];
            }

            if (sumaActual > maxTotal) {
                maxTotal = sumaActual;
            }
        }
        return maxTotal;
    }

    public static int[] generarArregloConSemilla(int n, long seed) {
        Random rand = new Random(seed); // La semilla asegura la misma secuencia
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // Generamos números entre -100 y 100
            arr[i] = rand.nextInt(201) - 100;
        }
        return arr;
    }
}