package school.faang;

import static school.faang.Example.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i ++) {
            printArray(nums);
            Example.reverse(nums);
            System.out.println("Развёрнутый массив:");
            printArray(nums);

            Example.reverse(nums);
            System.out.println("Развёрнутый массив:");
            printArray(nums);
        }
    }
}

