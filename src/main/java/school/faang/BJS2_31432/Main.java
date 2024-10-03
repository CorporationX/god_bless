package school.faang.BJS2_31432;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Example.reverse(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }
}
