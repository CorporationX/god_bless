package school.faang.bjs2_69339;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        var nums = new ArrayList<Integer>();
        nums.add(11);
        nums.add(32);
        nums.add(76);
        nums.add(99);
        nums.add(713);
        var numsCopy = new ArrayList<>(nums);

        Example.reverseNaive(nums);
        Example.reverse(numsCopy);

        System.out.println(nums);
        System.out.println(numsCopy);
    }
}