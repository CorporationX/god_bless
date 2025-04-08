package school.faang.reverse;

import java.util.Arrays;

import static school.faang.reverse.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.printf("Исходный массив: %s%n", Arrays.toString(nums));

        reverse(nums);
        System.out.printf("Развернутый массив: %s%n", Arrays.toString(nums));

        int[] emptyArray = {};
        System.out.printf("Исходный пустой массив: %s%n", Arrays.toString(emptyArray));
        reverse(emptyArray);
        System.out.printf("Развернутый пустой массив: %s%n", Arrays.toString(emptyArray));

        int[] singleElementArray = {7};
        System.out.printf("Исходный массив с одним элементом: %s%n", Arrays.toString(singleElementArray));
        reverse(singleElementArray);
        System.out.printf("Развернутый массив с одним элементом: %s%n", Arrays.toString(singleElementArray));
    }
}