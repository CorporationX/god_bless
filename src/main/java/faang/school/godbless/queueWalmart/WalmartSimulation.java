package faang.school.godbless.queueWalmart;

public class WalmartSimulation {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1);
            cashiers[i].setCustomerItems(customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
