package faang.school.godbless.BJS2_24031;

public class Main {

    private static final int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
    private static final Thread[] cashiers = new CashierThread[customers.length];

    public static void main(String[] args) {

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }

        for (Thread thread : cashiers) {
            thread.start();
        }
    }
}