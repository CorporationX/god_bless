package faang.school.godbless.queue_at_walmart;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {{5, 6, 7}, {1, 5, 4, 6}, {8, 9, 3}};
        CashierThread[] cashiers = new CashierThread[customers.length];

        for(int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }

        for(CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
