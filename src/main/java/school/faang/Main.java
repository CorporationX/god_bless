package school.faang;

import school.faang.thirdTask.Example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        arrayReverse();
    }

    private static void arrayReverse() {
        int[] nums = {1, 2, 3, 4, 5};
        Example.reverse(nums);

        System.out.println("Array reversed : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
