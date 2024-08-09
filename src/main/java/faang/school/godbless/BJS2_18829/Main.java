package faang.school.godbless.BJS2_18829;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Numbers в обычном порядке:");
        System.out.println(Arrays.toString(numbers));
        Example.reverse(numbers);
        System.out.println("Numbers после reverse:");
        System.out.println(Arrays.toString(numbers));
        Example.reverse(numbers);
        System.out.println("Numbers после второго revers:");
        System.out.println(Arrays.toString(numbers));
    }
}
