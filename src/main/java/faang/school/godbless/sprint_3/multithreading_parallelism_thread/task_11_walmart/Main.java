package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_11_walmart;

import java.util.Random;

public class Main {
    private static final int COUNT_CAHSHIERS = 4;
    private static final int MIN_COUNT_CUSTOMERS = 1;
    private static final int MAX_COUNT_CUSTOMERS = 5;
    private static final int MIN_COUNT_ITEMS = 1;
    private static final int MAX_COUNT_ITEMS = 10;
    private static final int MIN_PRICE = 100;
    private static final int MAX_PRICE = 500;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Customer[][] customers = new Customer[COUNT_CAHSHIERS][];
        CashierThread[] cashiers = new CashierThread[COUNT_CAHSHIERS];

        int suffix = 0;
        for (int i = 0; i < COUNT_CAHSHIERS; i++) {
            int customersCount = random.nextInt(MIN_COUNT_CUSTOMERS, MAX_COUNT_CUSTOMERS);
            customers[i] = new Customer[customersCount];

            for (int j = 0; j < customersCount; j++) {
                customers[i][j] = new Customer("customers_" + ++suffix, createBasket(random.nextInt(MIN_COUNT_ITEMS, MAX_COUNT_ITEMS)));
            }

            CashierThread cashier = new CashierThread(i + 1, customers[i]);
            cashier.start();
            cashiers[i] = cashier;
        }

        for (CashierThread c : cashiers) {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (CashierThread c : cashiers) {
            System.out.printf("В кассе у id: %d, total: %d.\n", c.getCashierId(), c.getTotal());
        }
    }

    public static Item[] createBasket(int count) {
        Item[] basket = new Item[count];

        for (int i = 0; i < count; i++) {
            basket[i] = new Item("item_" + 1, random.nextInt(MIN_PRICE, MAX_PRICE));
        }

        return basket;
    }
}
