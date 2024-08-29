package faang.school.godbless.task.multithreading.walmart.queue;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Configuration {
    private final static int NUMBER_OF_CUSTOMERS = 17;
    private final static int MAX_ITEM_PER_CUSTOMER = 5;
    private final static int MAX_ITEM_COST = 300;
    private final static int NUMBER_OF_CASHIERS = 4;

    private final Random random = new Random();

    public long getCashierId() {
        return random.nextInt(NUMBER_OF_CASHIERS - 1) + 1;
    }

    public List<Customer> getCustomers() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_CUSTOMERS)
                .mapToObj(i -> new Customer("Customer " + i, getItems()))
                .toList();
    }

    private List<CustomerItem> getItems() {
        return IntStream
                .rangeClosed(1, getNumberOfItem())
                .mapToObj(i -> new CustomerItem(getItemCost(), "Item " + i))
                .toList();
    }

    private int getItemCost() {
        return random.nextInt(MAX_ITEM_COST - 1) + 1;
    }

    private int getNumberOfItem() {
        return random.nextInt(MAX_ITEM_PER_CUSTOMER - 1) + 1;
    }

    public int getNumberOfCustomers() {
        return NUMBER_OF_CUSTOMERS;
    }

    public int getNumberOfCashiers() {
        return NUMBER_OF_CASHIERS;
    }
}
