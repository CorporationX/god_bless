package faang.school.godbless.Sprint4.Walaram;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        List<Object> cashiers = new LinkedList<>();

        for (int[] arr : customers) {
            cashiers.add(arr);
        }

        for (int i = 0; i < cashiers.size(); i++) {
            int[] arr = (int[]) cashiers.get(i);
            CashierThread act = new CashierThread(i, arr);
            act.start();
            cashiers.set(i, act);
        }

        int totalCost = 0;
        int totalAmount = 0;
        for (int i = 0; i < cashiers.size(); i++) {
            CashierThread act = (CashierThread) cashiers.get(i);
            act.join();
            totalCost += act.totalCost;
            totalAmount += act.totalAmount;
        }

        System.out.printf("MAIN --- All cost - %d, all amount - %d", totalCost, totalAmount);
    }
}
