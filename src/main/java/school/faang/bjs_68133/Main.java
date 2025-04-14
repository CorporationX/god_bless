package school.faang.bjs_68133;

import static school.faang.bjs_68133.Example.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i++) {
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

