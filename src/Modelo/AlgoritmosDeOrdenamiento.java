package Modelo;
import java.util.Arrays;

public class AlgoritmosDeOrdenamiento
{

    public static void mergeSort(int[] arr)
    {
        if(arr == null || arr.length <= 1) return;
        sort(arr, 0, arr.length - 1);
    }
    public static void sort(int [] arr, int left, int right)
    {

        if(left < right)
        {
            int middle = (left + right) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }

    }

    public static void merge(int[] arr, int left, int middle, int right)
    {
        int i = 0, j = 0;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for (i=0; i < n1; i++)
        {
            leftArray[i] = arr[left+i];
        }
        for (j=0; i < n2; j++)
        {
            rightArray[j] = arr[middle + j + 1];
        }

        int k = left;

        while (i < n1 && j < n2)
        {
            if (leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
            } else
            {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void shellSort(int[] arr)
    {
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    public static void countingSort(int[] arr)
    {
        if (arr.length == 0) return;
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int range = max - min + 1;

        int count[] = new int[range];
        int output[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) count[arr[i] - min]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void radixSort(int[] arr)
    {
        if (arr.length == 0) return;
        int min = Arrays.stream(arr).min().getAsInt();
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) arr[i] -= min;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) countSortForRadix(arr, exp);

        if (min < 0) {
            for (int i = 0; i < arr.length; i++) arr[i] += min;
        }
    }

    private static void countSortForRadix(int[] arr, int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

}
