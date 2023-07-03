package Multithreading.bc2314;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };
        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
        }
        int totalItems = 0;
        int totalPrice = 0;

        for (CashierThread thread : cashiers) {
            thread.join();
            totalItems += thread.getCountItem();
            totalPrice += thread.getPrice();
        }
        System.out.println();
        System.out.println("All customers served");
        System.out.println();
        System.out.println("Total items: " + totalItems);
        System.out.println("Total price: " + totalPrice);
    }
}
