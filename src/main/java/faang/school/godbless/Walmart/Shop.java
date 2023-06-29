package faang.school.godbless.Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        Map<Integer, Integer> cashiersData = new HashMap<>(customers.length);
        List<CashierThread> cashiers = new ArrayList<>(customers.length);

        for (int i = 0; i < customers.length; i++) {
            CashierThread cashierThread = new CashierThread(i + 1, customers[i]);
            cashiers.add(cashierThread);
        }

        for (int j = 0; j < customers.length; j++) {
            cashiers.get(j).start();
        }

        for (int z = 0; z < customers.length; z++) {
            CashierThread currentCashier = cashiers.get(z);

            try {
                currentCashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cashiersData.put(currentCashier.getCashierId(), currentCashier.getTotalCost());
        }

        System.out.println(
                "Income:\n" +
                "Cashier #1: " + cashiersData.get(1) + "\n" +
                "Cashier #2: " + cashiersData.get(2) + "\n" +
                "Cashier #3: " + cashiersData.get(3) + "\n" +
                "Cashier #4: " + cashiersData.get(4) + "\n" +
                "----------------------------------" + "\n" +
                "Total income: " + getTotalIncome(cashiersData));
    }

    static int getTotalIncome(Map<Integer, Integer> cashiersData) {
        return cashiersData.values().stream().reduce(Integer::sum).orElse(0);
    }
}
