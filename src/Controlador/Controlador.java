package Controlador;
import Vista.*;
import Modelo.*;
import java.util.Scanner;


public class Controlador
{

    final private Vista vista;
    final private GestorDatos modelo;
    private Scanner sc;

    public Controlador(Vista vista)
    {
        this.vista = vista;
        this.modelo = new GestorDatos();
        this.sc = new Scanner(System.in);

    }

    public void iniciarPrograma()
    {
        int opcion = 0;
        do
        {
            vista.menuInicial();
            opcion = vista.pedirOpcion();
            ejecutarOpcion(opcion);
        }
        while (opcion != 9);
    }

    private void ejecutarOpcion(int opcion)
    {
        if (opcion != 1 && opcion != 9 && !modelo.hayDatos())
        {
            System.out.println(Vista.ROJO + "Error: Primero genere la matriz (Opción 1)." + Vista.RESET);
            return;
        }

        long inicio, fin, inicioOrden, finOrden;
        int[] arrTrabajo;

        switch(opcion)
        {
            case 1:
                System.out.println( "");
                modelo.generarDatos();
                break;
            case 2:
                arrTrabajo = modelo.getCopiaArreglo();
                System.out.println("Ejecutando Merge Sort...");
                inicio = System.nanoTime();
                AlgoritmosDeOrdenamiento.mergeSort(arrTrabajo);
                fin = System.nanoTime();
                System.out.println(Vista.VERDE + "Tiempo Merge Sort: " + (fin - inicio) + " ns" + Vista.RESET);
                break;
            case 3:
                arrTrabajo = modelo.getCopiaArreglo();
                System.out.println("Ejecutando Shell Sort...");
                inicio = System.nanoTime();
                AlgoritmosDeOrdenamiento.shellSort(arrTrabajo);
                fin = System.nanoTime();
                System.out.println(Vista.VERDE + "Tiempo Shell Sort: " + (fin - inicio) + " ns" + Vista.RESET);
                break;
            case 4:
                arrTrabajo = modelo.getCopiaArreglo();
                System.out.println("Ejecutando Counting Sort...");
                inicio = System.nanoTime();
                AlgoritmosDeOrdenamiento.countingSort(arrTrabajo);
                fin = System.nanoTime();
                System.out.println(Vista.VERDE + "Tiempo Counting Sort: " + (fin - inicio) + " ns" + Vista.RESET);
                break;
            case 5:
                arrTrabajo = modelo.getCopiaArreglo();
                System.out.println("Ejecutando Radix Sort...");
                inicio = System.nanoTime();
                AlgoritmosDeOrdenamiento.radixSort(arrTrabajo);
                fin = System.nanoTime();
                System.out.println(Vista.VERDE + "Tiempo Radix Sort: " + (fin - inicio) + " ns" + Vista.RESET);
                break;
            case 6:
                System.out.print("Ingrese número a buscar: ");
                try {
                    int x = Integer.parseInt(sc.nextLine());

                    System.out.println("Preparando datos (Ordenando con Merge Sort)...");

                    arrTrabajo = modelo.getCopiaArreglo();
                    inicioOrden = System.nanoTime();
                    AlgoritmosDeOrdenamiento.mergeSort(arrTrabajo);
                    finOrden = System.nanoTime();
                    long tiempoOrdenamiento = finOrden - inicioOrden;

                    System.out.println("Realizando busqueda...");
                    inicio = System.nanoTime();
                    int idx_positivo = AlgoritmosDeBusqueda.busquedaBinaria(arrTrabajo, x);
                    int idx_negativo = AlgoritmosDeBusqueda.busquedaBinaria(arrTrabajo, -x);
                    fin = System.nanoTime();
                    long tiempoBusqueda = fin - inicio;

                    System.out.println(Vista.CYAN + "Resultado para " + x + ": " + Vista.RESET +
                            (idx_positivo != -1 ? Vista.VERDE + "Encontrado en índice " + idx_positivo : Vista.ROJO + "No encontrado") + Vista.RESET);
                    System.out.println(Vista.CYAN + "Resultado para " + (-x) + ": " + Vista.RESET +
                            (idx_negativo != -1 ? Vista.VERDE + "Encontrado en índice " + idx_negativo : Vista.ROJO + "No encontrado") + Vista.RESET);

                    // TIEMPOS DESGLOSADOS
                    System.out.println("\n" + Vista.CYAN + "═══════════════════════════════════════" + Vista.RESET);
                    System.out.println(Vista.AMARILLO + "  Tiempo Ordenamiento (Merge Sort): " + tiempoOrdenamiento + " ns" + Vista.RESET);
                    System.out.println(Vista.AMARILLO + "  Tiempo Búsqueda Binaria:          " + tiempoBusqueda + " ns" + Vista.RESET);
                    System.out.println(Vista.CYAN + "───────────────────────────────────────" + Vista.RESET);
                    System.out.println(Vista.VERDE + "  TIEMPO TOTAL:                      " + (tiempoOrdenamiento + tiempoBusqueda) + " ns" + Vista.RESET);
                    System.out.println(Vista.CYAN + "═══════════════════════════════════════" + Vista.RESET);
                }catch (Exception e)
                {
                    System.out.println(Vista.ROJO + "Entrada inválida." + Vista.RESET);
                }
                break;
            case 7:
                System.out.print("Ingrese número a buscar: ");
                try {
                    int x = Integer.parseInt(sc.nextLine());
                    arrTrabajo = modelo.getCopiaArreglo(); // Datos crudos

                    inicio = System.nanoTime();
                    int idx = AlgoritmosDeBusqueda.busquedaSecuencial(arrTrabajo, x);
                    fin = System.nanoTime();

                    if(idx != -1) System.out.println(Vista.VERDE + "Encontrado en índice: " + idx + Vista.RESET);
                    else System.out.println(Vista.ROJO + "No encontrado." + Vista.RESET);
                    System.out.println(Vista.CYAN + "Tiempo Búsqueda Secuencial: " + (fin - inicio) + " ns" + Vista.RESET);
                } catch(Exception e) { System.out.println(Vista.ROJO + "Entrada inválida." + Vista.RESET); }
                break;
           case 8:
               System.out.print("Ingrese número a buscar: ");
               try {
                   int x = Integer.parseInt(sc.nextLine());

                   System.out.println("Preparando datos (ordenando con Merge Sort)...");
                   arrTrabajo = modelo.getCopiaArreglo();
                   inicioOrden = System.nanoTime();
                   AlgoritmosDeOrdenamiento.mergeSort(arrTrabajo);
                   finOrden = System.nanoTime();
                   long tiempoOrdenamiento = finOrden - inicioOrden;

                   System.out.println("Buscando...");
                   inicio = System.nanoTime();
                   int idx =  AlgoritmosDeBusqueda.busquedaPorInterpolacion(arrTrabajo, x);
                   fin = System.nanoTime();
                   long tiempoBusqueda = fin - inicio;

                   if(idx != -1) System.out.println(Vista.VERDE + "Encontrado en índice: " + idx + Vista.RESET);
                   else System.out.println(Vista.ROJO + "No encontrado." + Vista.RESET);

                   // TIEMPOS DESGLOSADOS
                   System.out.println("\n" + Vista.CYAN + "═══════════════════════════════════════" + Vista.RESET);
                   System.out.println(Vista.AMARILLO + "  Tiempo Ordenamiento (Merge Sort): " + tiempoOrdenamiento + " ns" + Vista.RESET);
                   System.out.println(Vista.AMARILLO + "  Tiempo Búsqueda Interpolación:    " + tiempoBusqueda + " ns" + Vista.RESET);
                   System.out.println(Vista.CYAN + "───────────────────────────────────────" + Vista.RESET);
                   System.out.println(Vista.VERDE + "  TIEMPO TOTAL:                      " + (tiempoOrdenamiento + tiempoBusqueda) + " ns" + Vista.RESET);
                   System.out.println(Vista.CYAN + "═══════════════════════════════════════" + Vista.RESET);
               } catch(Exception e) { System.out.println(Vista.ROJO + "Entrada inválida." + Vista.RESET); }
               break;
           case 9:
               System.out.println("Gracias por usar el programa!!");
               break;
            default:
                System.out.println(Vista.ROJO + "Opción no válida." + Vista.RESET);

        }
    }
}
