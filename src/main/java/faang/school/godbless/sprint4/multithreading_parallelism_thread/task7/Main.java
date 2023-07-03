package faang.school.godbless.sprint4.multithreading_parallelism_thread.task7;

public class Main {

    public static void main(String[] args) {
        int[][] customers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            CashierThread cashierThread = new CashierThread(i, customers[i]);
            cashiers[i] = cashierThread;
        }

        for (CashierThread cashierThread : cashiers) {
            cashierThread.start();
        }
    }
}
