package faang.school.godbless.Sprint2.task5;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            swap(i, len - i-1, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static class Main {
        public static void main(String[] args) {
            int[] testArrEven = {0, 1, 2, 3, 4, 5};
            System.out.printf("test1-even\n%s\n", Arrays.toString(testArrEven));
            reverse(testArrEven);
            System.out.println(Arrays.toString(testArrEven));

            int[] testArrOdd = {0, 1, 2, 3, 4};
            System.out.printf("test2 - odd\n%s\n",Arrays.toString(testArrOdd));
            reverse(testArrOdd);
            System.out.println(Arrays.toString(testArrOdd));
        }
    }
}
