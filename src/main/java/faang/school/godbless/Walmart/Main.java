package faang.school.godbless.Walmart;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[][] customers = getCustomerProducts();
        CashierThread[] cashiers = getCashierThreads(customers);

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }

    private static CashierThread[] getCashierThreads(Product[][] customers) {
        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, Arrays.asList(customers[i]));
        }
        return cashiers;
    }

    private static Product[][] getCustomerProducts() {
        return new Product[][]{
                {new Product("Cheese", 100), new Product("Milk", 80)},
                {new Product("Beacon", 90), new Product("Chips", 70), new Product("Cola", 70)},
                {new Product("Tea", 40), new Product("Bread", 45), new Product("Milk", 80)},
                {new Product("Cigarettes", 100), new Product("Coffee", 120)}
        };
    }
}
