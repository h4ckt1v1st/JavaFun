import java.util.Arrays;
import java.util.Random;

public class MergeSort {

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
        mergeSort(numbers);
        long endTime = System.nanoTime();

        System.out.println("Sorting done. Time taken is " + ((endTime - startTime)/1_000_000.0) + " milliseconds.");
        if (PRIINT_ARRAY) {
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        System.arraycopy(inputArray, 0, leftHalf, 0, midIndex);
        System.arraycopy(inputArray, midIndex, rightHalf, 0, inputLength-midIndex);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while(j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
