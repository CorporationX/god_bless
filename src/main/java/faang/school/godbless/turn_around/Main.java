package faang.school.godbless.turn_around;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] num = new int[]{1, 2, 3, 4, 5};
        Arrays.stream(num).forEach(System.out::println);
        int[] res = example.reverse(num);
        Arrays.stream(res).forEach(System.out::println);
    }
}
