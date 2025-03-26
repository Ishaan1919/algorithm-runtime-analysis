import java.util.Random;
import java.util.Arrays;

public class SortingLargeData {
    public static void main(String[] args) {
        int size = 10000; // Adjust for larger datasets
        int[] array1 = generateRandomArray(size);
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();

        // Bubble Sort
        long start = System.currentTimeMillis();
        bubbleSort(array1);
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (end - start) + "ms");

        // Merge Sort
        start = System.currentTimeMillis();
        mergeSort(array2, 0, array2.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort Time: " + (end - start) + "ms");

        // Quick Sort
        start = System.currentTimeMillis();
        quickSort(array3, 0, array3.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Quick Sort Time: " + (end - start) + "ms");

//        Bubble Sort Time: 297ms
//        Merge Sort Time: 8ms
//        Quick Sort Time: 5ms
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000); // Random numbers up to 100,000
        }
        return arr;
    }

    // Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}