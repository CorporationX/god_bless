package school.faang.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> taken = numbers.stream()
                .dropWhile(x -> x > 2)
                .collect(Collectors.toList());
        System.out.println(taken);


    }
}
