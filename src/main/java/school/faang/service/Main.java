package school.faang.service;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println(Arrays.toString(Example.reverse(nums)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}