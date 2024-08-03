package faang.school.godbless.BJS2_18829;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Arrays.stream(numbers).forEach(System.out::println);
        System.out.println("------------");
        int[] reverseNumbers = Example.reverse(numbers);
        Arrays.stream(reverseNumbers).forEach(System.out::println);
    }
}
