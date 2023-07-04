package faang.school.godbless.multithreading.queue_walmart;

import java.util.List;

public class Walmart {
    public static void main(String[] args) {
        int[][] customers1 = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        int[][] customers2 = {{6, 3, 3, 1}, {3, 4, 3}, {8, 11, 2}, {13, 5, 1, 3, 5}};

        List<CashierThread> cashiers = List.of(
                new CashierThread(1, customers1),
                new CashierThread(2, customers2)
        );
        cashiers.forEach(CashierThread::start);
    }
}
