package school.faang.sprint_3.task_47738;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int AMOUNT_OF_CUSTOMERS = 5;
    private static final int AMOUNT_OF_ITEMS_PER_CUSTOMER = 5;
    private static final int AMOUNT_OF_CASHIERS = 3;

    public static void main(String[] args) {
        List<List<Item>> customersWithItems = generateCustomers(AMOUNT_OF_CUSTOMERS, AMOUNT_OF_ITEMS_PER_CUSTOMER);

        List<CashierThread> cashiers = new ArrayList<>();

        Random random = new Random();

        for (List<Item> customersWithItem : customersWithItems) {
            CashierThread cashierThread = new CashierThread(random.nextInt(AMOUNT_OF_CASHIERS) + 1,
                    customersWithItem);
            cashiers.add(cashierThread);
            cashierThread.start();
        }

        try {
            for (CashierThread cashier : cashiers) {
                cashier.join();
            }
            System.out.println("All cashiers end work");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
    }

    private static List<List<Item>> generateCustomers(int amountOfCustomers, int amountOfItemsPerCustomer) {
        List<List<Item>> customers = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= amountOfCustomers; i++) {
            List<Item> items = new ArrayList<>();
            for (int j = 1; j <= amountOfItemsPerCustomer; j++) {
                items.add(new Item("Item " + i + j, random.nextInt(10000)));
            }
            customers.add(items);
        }
        return customers;
    }


}
