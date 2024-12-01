package school.faang;

import school.faang.moduleone.turnaround.Example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] source = {3, 10, 15, 8, 12};
        System.out.println(Arrays.toString(Example.reverse(source)));
        System.out.println(Arrays.toString(Example.reverseWithoutAdditionalArray(source)));
    }
}
