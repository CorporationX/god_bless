package faang.school.godbless;


import java.util.Arrays;

public class Example {
    int[] reverse(int array[]) {
        int temp;
        for (int index = array.length - 1, reversedIndex = 0; reversedIndex < array.length / 2; index--, reversedIndex++) {
            temp = array[reversedIndex];
            array[reversedIndex] = array[index];
            array[index] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(Arrays.toString(example.reverse(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(example.reverse(new int[]{23, -17, 85, 32})));
    }
}
