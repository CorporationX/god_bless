package school.faang;

import static school.faang.Example.Reverse;
import static school.faang.Example.printArray;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Исходный массив:");
        printArray(nums);


        Reverse(nums);

        System.out.println("Развёрнутый массив:");
        printArray(nums);

    }
}
