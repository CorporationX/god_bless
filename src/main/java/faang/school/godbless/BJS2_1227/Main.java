package faang.school.godbless.BJS2_1227;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] customers = new String[][]{
                {"Coke", "Pizza"},
                {"Apple Juice", "Orange Juice", "Ice cream", "Bread"},
                {"Bike", "Water", "Snack"},
        };
        CashierThread[] cashiers = new CashierThread[customers.length];

        int i = 0;
        for (String[] customer : customers) {
            cashiers[i] = new CashierThread(Arrays.asList(customer), i++);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}