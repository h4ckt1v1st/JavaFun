import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static final boolean PRIINT_ARRAY = true;
    private static final int ACTUAL_SIZE_OF_ARRAY = 10;

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[ACTUAL_SIZE_OF_ARRAY];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Starting to sort array.");
        if (PRIINT_ARRAY) {
            System.out.println(Arrays.toString(numbers));
        }

        long startTime = System.nanoTime();
        quickSort(numbers);
        long endTime = System.nanoTime();

        System.out.println("Sorting done. Time taken is " + ((endTime - startTime)/1_000_000.0) + " milliseconds.");
        if (PRIINT_ARRAY) {
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex){
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quickSort(array, lowIndex, leftPointer-1);
        quickSort(array, leftPointer+1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
