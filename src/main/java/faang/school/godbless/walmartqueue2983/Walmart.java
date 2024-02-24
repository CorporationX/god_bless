package faang.school.godbless.walmartqueue2983;

import java.util.ArrayList;

public class Walmart {
    public static void main(String[] args) throws InterruptedException {
        String[][] customers = createCustomers();
        CashierThread[] cashiers = createCashiers(customers);
        double totalMoneyEarned = 0.00;
        int totalItemsScanned = 0;

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        Thread.sleep(5000L);
        System.out.println();

        for (CashierThread cashier : cashiers) {
            System.out.println(cashier);
            totalMoneyEarned += cashier.getDollarsEarned();
            totalItemsScanned += cashier.getScannedItems().size();
        }
        System.out.printf("Total money earned - %.2f$%nTotal items scanned - %d%n", totalMoneyEarned, totalItemsScanned);
    }

    private static CashierThread[] createCashiers(String[][] customers) {
        int customersQuantity = customers.length;
        CashierThread[] result = new CashierThread[customersQuantity];
        for (int i = 0; i < customersQuantity; i++) {
            result[i] = new CashierThread(i + 1, customers[i], new ArrayList<>());
        }
        return result;
    }

    private static String[][] createCustomers() {
        return new String[][]{{"Bread", "Eggs", "Onions", "Cucumbers"},
                              {"Tomatoes", "Carrots", "Ground beef", "Butter", "Orange juice", "Ice cream"},
                              {"Butter", "Yogurt", "Cheese", "Bread", "Orange juice"},
                              {"Lettuce", "Cheese"},
                              {"Apples", "Bananas", "Butter", "Pasta"}};
    }
}
