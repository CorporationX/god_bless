package faang.school.godbless.sprint4.queueWallmart.classes;

public class Main {
    public static void main(String[] args) {
        int totalSum = 0;
        int countItems = 0;
        int[][] customerItems = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5},
        };

        CashierThread[] cashierThreads = new CashierThread[customerItems.length];

        for (int i = 0; i < customerItems.length; i++) {
            cashierThreads[i] = new CashierThread(i, customerItems[i]);
            cashierThreads[i].start();
        }

        for (CashierThread cashierThread : cashierThreads) {
            try {
                cashierThread.join();
                totalSum += cashierThread.getTotalSum();
                countItems += cashierThread.getCountItems();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total sum: " + totalSum + ", count items: " + countItems);
    }
}