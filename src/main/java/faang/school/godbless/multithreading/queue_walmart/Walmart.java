package faang.school.godbless.multithreading.queue_walmart;

public class Walmart {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        for (int i = 0; i < customers.length; i++) {
            new CashierThread(i, customers[i]).start();
        }
    }
}
