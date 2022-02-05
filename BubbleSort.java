import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    private static final boolean PRIINT_ARRAY = false;
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
        bubbleSort(numbers);
        long endTime = System.nanoTime();

        System.out.println("Sorting done. Time taken is " + ((endTime - startTime)/1_000_000.0) + " milliseconds.");
        if (PRIINT_ARRAY) {
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static void bubbleSort(int[] numbers) {
        boolean swappedSomething = true;
        while (swappedSomething) {
            swappedSomething = false;
            for (int i = 0; i < numbers.length-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    swappedSomething = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
        }
    }
}
