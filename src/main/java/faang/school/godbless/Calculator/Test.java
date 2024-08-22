package faang.school.godbless.Calculator;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> intList = List.of(2, 3, 4);
        List<Double> doubleList = List.of(2.0, 3.0, 4.0);
        List<Float> floatList = List.of(2.0f, 3.0f, 4.0f);

        System.out.println("Product of Integers: " + Math.product(intList));
        System.out.println("Sum of Doubles: " + Math.sum(doubleList));
        System.out.println("Difference of Floats: " + Math.dif(floatList));
        System.out.println("Division of Doubles: " + Math.div(doubleList));
    }
}
