package faang.school.godbless.parallel.queue_in_walmart;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {
                {10, 20, 30},
                {15, 25},
                {5, 10, 15, 20}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}

