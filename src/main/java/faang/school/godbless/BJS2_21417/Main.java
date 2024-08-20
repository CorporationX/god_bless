package faang.school.godbless.BJS2_21417;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 4, 6, 9, 12, 24);
        System.out.println(calculate(numbers, Integer::sum));
    }

    public static int calculate(List<Integer> numbers, Calculator calculator){
        return numbers.stream().reduce(0, calculator::calculate);
    }
}
