package school.faang.sprint_1.task_bjs2n43622;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        int[] arrayEven = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] arrayOdd = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayZero = new int[]{};
        int[] arrayLengthOne = new int[]{1};
        int[] arrayLengthTwo = new int[]{1, 2};
        int[] arrayLengthThree = new int[]{1, 2, 3};
        example.reverse(arrayEven);
        example.reverse(arrayOdd);
        example.reverse(arrayZero);
        example.reverse(arrayLengthOne);
        example.reverse(arrayLengthTwo);
        example.reverse(arrayLengthThree);

        System.out.print("\narrayEven reversed:\t");
        printOutArray(arrayEven);

        System.out.print("\narrayOdd reversed:\t");
        printOutArray(arrayOdd);

        System.out.print("\narrayZero reversed:\t");
        printOutArray(arrayZero);

        System.out.print("\narrayLengthOne reversed:\t");
        printOutArray(arrayLengthOne);

        System.out.print("\narrayLengthTwo reversed:\t");
        printOutArray(arrayLengthTwo);

        System.out.print("\narrayLengthThree reversed:\t");
        printOutArray(arrayLengthThree);


    }

    public static void printOutArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
