package faang.school.godbless;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println("sum " + GoogleCalculator.sum(nums));
        System.out.println("product " + GoogleCalculator.product(nums));

    }
}
