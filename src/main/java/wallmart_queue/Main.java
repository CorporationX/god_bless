package wallmart_queue;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        String[][] customers = {
                {"apple", "banana", "orange"},
                {"banana", "orange", "orange", "apple"},
                {"apple", "apple", "apple"}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }
    }
}
