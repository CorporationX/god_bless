package school.faang.reverse;

import java.util.Arrays;

import static school.faang.reverse.Reverse.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Исходный массив: " + Arrays.toString(nums));

        reverse(nums);
        System.out.println("Развернутый массив: " + Arrays.toString(nums));

        int[] emptyArray = {};
        System.out.println("Исходный пустой массив: " + Arrays.toString(emptyArray));
        reverse(emptyArray);
        System.out.println("Развернутый пустой массив: " + Arrays.toString(emptyArray));

        int[] singleElementArray = {7};
        System.out.println("Исходный массив с одним элементом: " + Arrays.toString(singleElementArray));
        reverse(singleElementArray);
        System.out.println("Развернутый массив с одним элементом: " + Arrays.toString(singleElementArray));
    }
}
