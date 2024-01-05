package faang.school.godbless.done.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        long multiply = Operations.multiply(new ArrayList<>(List.of(2147483647L, 2L)));
        long sum = Operations.sum(new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L)));
        System.out.println("multiply: " + multiply + "\nsum: " + sum);
    }
}
