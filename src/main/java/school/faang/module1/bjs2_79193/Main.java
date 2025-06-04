package school.faang.module1.bjs2_79193;

import java.util.Arrays;

import static school.faang.module1.bjs2_79193.Example.reverse;

public class Main {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("До разворота:");
        System.out.println(Arrays.toString(nums));
        reverse(nums);
        System.out.println("После разворота:");
        System.out.println(Arrays.toString(nums));
    }
}
