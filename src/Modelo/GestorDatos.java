package Modelo;
import java.util.Random;

public class GestorDatos
{

    private int[][] matriz;
    private final int FILAS = 1000;
    private final int COLS = 1000;
    private boolean datosGenerados = false;

    public GestorDatos() {
        this.matriz = new int[FILAS][COLS];
    }

    //Generar matriz de 1000 x 1000 bidimensional
    public void generarDatos()
    {
        Random rand = new Random();
        System.out.println("Generando matriz de " + FILAS + "x" + COLS + "...");

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLS; j++) {
                // Generamos números aleatorios entre -1000000 y 1000000
                matriz[i][j] = rand.nextInt(2000001) - 1000000;
            }
        }
        datosGenerados = true;
        System.out.println("Matriz generada exitosamente.");
    }

    //Transformar el arreglo 2D a 1D para poder aplicar los algoritmos de ordenamiento.
    public int[] getCopiaArreglo() {
        if (!datosGenerados) return null;

        int[] arregloPlano = new int[FILAS * COLS];
        int k = 0;

        for (int i = 0; i < FILAS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                arregloPlano[k++] = matriz[i][j];
            }
        }
        return arregloPlano;
    }

    public boolean hayDatos()
    {
        return datosGenerados;
    }


}
