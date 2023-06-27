package faang.school.godbless.thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        List<CashierThread> cashiers = new ArrayList<>();

        for (int i = 0; i < customers.length; i++) {
            cashiers.add(new CashierThread(i + 1, customers[i]));
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
            cashier.join();
        }
    }
}
