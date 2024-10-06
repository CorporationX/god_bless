package school.faang;

import school.faang.thirdTask.Example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Example.reverse(nums);

        System.out.println("ArrayList reversed : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
