import java.util.Random;
public class QuickSort {

    // Método principal QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    //Método para dividir el arreglo (Partition)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Se toma el último elemento como pivote
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    //Método para intercambiar elementos
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Método para generar arreglo aleatorio
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    //Método principal de prueba
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000, 40000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            long startTime = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();

            double executionTime = (endTime - startTime) / 1_000_000.0;

            System.out.println("Tamaño: " + size + 
                        " | Tiempo de ejecución: " + executionTime + " ms");
        }
    }
}

