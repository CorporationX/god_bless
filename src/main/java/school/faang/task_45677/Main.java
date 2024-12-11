package school.faang.task_45677;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int product = OperationProcessor.product(List.of(1, 2, 3, 4));
        System.out.println(product);

        int sum = OperationProcessor.sum(List.of(1, 2, 3, 4));
        System.out.println(sum);
    }
}
