package school.faang.calc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Sum: " + AnalyticsCollectionSystem.sum(numbers));
        System.out.println("Product: " + AnalyticsCollectionSystem.product(numbers));
    }
}
