package faang.school.godbless.multithreading.queue_walmart;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Customer> customers1 = setUp(1, 3);
        List<Customer> customers2 = setUp(4, 6);
        List<CashierThread> cashiers = List.of(
                new CashierThread(1, customers1),
                new CashierThread(2, customers2)
        );

        cashiers.forEach(CashierThread::start);
        for (CashierThread cashier : cashiers) {
            cashier.join();
        }
    }

    private static List<Customer> setUp(int idRangeStart, int idRangeEnd) {
        return IntStream.rangeClosed(idRangeStart, idRangeEnd)
                .mapToObj(i -> new Customer(i, new Random().ints(100, 1000)
                        .limit(3)
                        .mapToObj(Item::new)
                        .toList()))
                .toList();
    }
}
