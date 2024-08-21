package walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        int cashiersCount = RANDOM.nextInt(10) + 10;
        List<List<Item>> customers = new ArrayList<>(cashiersCount);
        for (int i = 0; i < cashiersCount; i++) {
            customers.add(i, getNewShoppingCart(i));
        }
        List<CashierThread> cashiers = new ArrayList<>();
        for (int i = 0; i < cashiersCount; i++) {
            cashiers.add(i, new CashierThread(i, customers.get(i)));
        }
        cashiers.forEach(Thread::start);
        for (CashierThread cashier : cashiers) {
            cashier.join();
        }
        cashiers.forEach(c -> System.out.printf("Cash box №%d processed %d items, with total price %d%n",
                c.getCashierId(), c.getItems().size(), c.getCacheBank()));
    }

    public static List<Item> getNewShoppingCart(int customerId) {
        var items = new ArrayList<Item>();
        int size = RANDOM.nextInt(10) + 1;
        for (int i = 0; i < size; i++) {
            items.add(new Item("item" + customerId + i, RANDOM.nextInt(900) + 100));
        }

        return items;
    }
}
