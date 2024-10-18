package school.faang.queue_to_walmart_BJS2_36250;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] customers = {{"gallon of milk", "potatoes",}
                , {"eggs", "can of black beans", "spinach"}
                , {"boneless chicken breasts", "strawberries", "toilet paper", "jar of peanut butter"}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
            cashiers[i].start();
        }

        for (CashierThread thread : cashiers) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (CashierThread cashier : cashiers) {
            int maxPrice = 5000;
            System.out.printf("Customer was served by cashier: %d, bought %d items , total price %d\n"
                    , cashier.getCashierId(), cashiers.length, new Random().nextInt(maxPrice));
        }
    }
}
