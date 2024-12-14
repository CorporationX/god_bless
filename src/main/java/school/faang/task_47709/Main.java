package school.faang.task_47709;

import java.util.Random;

public class Main {
    private static final int NUM_OF_CASHIERS = 3;

    public static void main(String[] args) {
        Customer[] customers = new Customer[] {
                new Customer(new double[]{10.5, 20.3, 15.0, 7.99}),
                new Customer(new double[]{5.99, 8.5, 12.0, 4.75}),
                new Customer(new double[]{3.0, 4.5, 7.2}),
                new Customer(new double[]{8.5, 2.0, 10.0, 15.3})
        };
        CashierThread[] cashierThreads = new CashierThread[NUM_OF_CASHIERS];

        for (int i = 0; i < NUM_OF_CASHIERS; i++) {
            cashierThreads[i] = new CashierThread(i + 1);
        }

        for (Customer customer : customers) {
            int cashierId = new Random().nextInt(NUM_OF_CASHIERS);
            cashierThreads[cashierId].addCustomer(customer);
        }

        for (CashierThread cashierThread : cashierThreads) {
            cashierThread.start();
        }
    }
}
