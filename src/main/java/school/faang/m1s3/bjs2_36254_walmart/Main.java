package school.faang.m1s3.bjs2_36254_walmart;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {
                {100, 50, 200},
                {200, 50, 100},
                {300, 150, 500},
                {100, 250, 400},
        };
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }

        Arrays.stream(cashiers).forEach(CashierThread::start);

        Arrays.stream(cashiers).forEach(cashier -> {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        int totalRevenue = Arrays.stream(cashiers).
                mapToInt(CashierThread::getTotalMoneyEarned).
                sum();

        System.out.println("Work is done");
        System.out.printf("%d customers served, $%d total revenue", customers.length, totalRevenue);

    }
}
