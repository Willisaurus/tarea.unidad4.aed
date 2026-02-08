package Vista;

import java.util.Scanner;

public class Vista
{
    Scanner sc;
    public Vista ()
    {
        this.sc = new Scanner(System.in);
    }

    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO_BRILLANTE = "\u001B[97m";

    public static void menuInicial()
    {

        System.out.println(CYAN + "==============================" + RESET);
        System.out.println(CYAN + "==============================" + RESET);
        System.out.println(AZUL + "     MENU DE OPCIONES    " + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [1]. Generar matriz aleatoria de 1000 x 1000" + RESET);
        System.out.println(BLANCO_BRILLANTE + " [2]. Ordenamiento con Merge Sort" + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [3]. Ordenamiento con Shell Sort" + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [4]. Ordenamiento con Counting Sort" + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [5]. Ordenamiento con Radix Sort" + RESET);
        System.out.println(CYAN + "==============================" + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [6]. Búsqueda binaria" + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [7]. Búsqueda secuencial" + RESET);
        System.out.println(BLANCO_BRILLANTE  + " [8]. Búsqueda por interpolación" + RESET);
        System.out.println(ROJO + " [9]. Salir" + RESET);
        System.out.println(CYAN + "==============================" + RESET);
        System.out.println(CYAN + "==============================" + RESET);

    }

    public int pedirOpcion()
    {
        try
        {
            int opcion = Integer.parseInt(sc.nextLine());
            return opcion;
        } catch (NumberFormatException e)
        {
            System.out.println("Error: Debe ingresar un número válido." + RESET);
            return -1;
        }
    }

}
