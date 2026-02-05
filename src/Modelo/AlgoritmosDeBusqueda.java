package Modelo;

public class AlgoritmosDeBusqueda
{

    public static int busquedaBinaria(int[] arr, int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x) return m;

            if (arr[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static int busquedaSecuencial(int[] arr, int x)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public static int busquedaPorInterpolacion(int[] arr, int x)
    {
        int lo = 0, hi = (arr.length - 1);

        while (lo <= hi && x >= arr[lo] && x <= arr[hi])
        {
            if (lo == hi)
            {
                if (arr[lo] == x) return lo;
                return -1;
            }
            int pos = lo + (int)(((double)(hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));

            if (arr[pos] == x) return pos;

            if (arr[pos] < x) lo = pos + 1;
            else hi = pos - 1;
        }
        return -1;
    }

}

