package faang.school.godbless.reverse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        Arrays.stream(Example.reverse(array)).forEach(System.out::println);
    }
}
