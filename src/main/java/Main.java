import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        double sum = DataCenterCalculator.sum(numbers);
        System.out.println(sum);

        double product = DataCenterCalculator.product(numbers);
        System.out.println(product);
    }
}


