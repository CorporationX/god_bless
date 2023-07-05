package faang.school.godbless.task.queueAtWalmart;

public class Main {
    public static void main(String[] args) {
        int[][] customerItems = new int[][]{
                {1, 2, 3, 4, 5},
                {11, 12, 13},
                {21, 22},
                {31, 32, 33, 34}
        };

        CashierThread[] cashiers = new CashierThread[customerItems.length];

        for (int i = 0; i < customerItems.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customerItems[i]);
        }

        for (var cashier : cashiers) {
            cashier.start();
        }

        for (var cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int soldItemsCount = 0;
        int soldItemsPrice = 0;
        for (var cashier : cashiers) {
            soldItemsCount += cashier.getSoldItemsCount();
            soldItemsPrice += cashier.getSoldItemsPrice();
            System.out.println("Cashier " + cashier.getCashierId() + ": " + cashier.getSoldItemsCount() + " items sold for " + cashier.getSoldItemsPrice() + "$");
        }

        System.out.println("Total: " + soldItemsCount + " items sold for " + soldItemsPrice + "$");
    }
}
