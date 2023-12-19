package faang.school.godbless.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        Number multiply = Operations.multiply(new ArrayList<>(List.of(2147483647f, 2f)));
        Number sum = Operations.sum(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        System.out.println("multiply: " + multiply + "\nsum: " + sum);
    }
}
