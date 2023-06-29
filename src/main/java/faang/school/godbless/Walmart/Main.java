package faang.school.godbless.Walmart;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> customers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(1, 2, 3, 99),
                List.of(20),
                Arrays.asList(9, 9, 9, 9, 9)
        );
        List<CashierThread> cashiers;
        cashiers = Stream.iterate(0, i -> i + 1).limit(5).map(i -> new CashierThread(i, customers.get(i))).toList();
        cashiers.forEach(Thread::start);
    }
}
