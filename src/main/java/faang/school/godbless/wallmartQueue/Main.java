package faang.school.godbless.wallmartQueue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};

        List<CashierThread> cashiers = new ArrayList<>(customers.length);
        for (int i = 0; i < customers.length; i++) {
            cashiers.add(new CashierThread(i, customers[i]));
            cashiers.get(i).start();
        }
        for (int i = 0; i < customers.length; i++) {
            try {
                cashiers.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("all customers are served");
        for (CashierThread cashier : cashiers) {
            System.out.println("Check: " + cashier.getNumberOfItems() + " items total cost " + cashier.getTotalCost());
        }
    }
}
