package faang.school.godbless.walmart_queue;

public class Store {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].start();
        }
    }
}
