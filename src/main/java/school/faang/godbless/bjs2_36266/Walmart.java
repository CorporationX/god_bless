package school.faang.godbless.bjs2_36266;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class Walmart {
    public static void main(String[] args) throws InterruptedException {
        Item item1 = new Item("Item1", 100);
        Item item2 = new Item("Item2", 2);
        List<List<Item>> customers = getCustomers(item1, item2);
        List<CashierThread> cashiers = new ArrayList<>();
        customers.forEach(customer -> {
            CashierThread cashierThread = new CashierThread(UUID.randomUUID().toString(), customer);
            cashierThread.start();
            cashiers.add(cashierThread);
        });
        int totalItems = 0;
        int totalPrice = 0;
        for (CashierThread t : cashiers) {
            t.join();
            totalItems += t.getProcessedItemsCount();
            totalPrice += t.getTotalPrice();
        }
        log.info("Total items: {} Total price: {}", totalItems, totalPrice);
    }

    private static List<List<Item>> getCustomers(Item item1, Item item2) {
        Item item3 = new Item("Item3", 127);
        Item item4 = new Item("Item4", 1000);
        Item item5 = new Item("Item5", 99);
        Item item6 = new Item("Item6", 18);
        Item item7 = new Item("Item7", 78);
        Item item8 = new Item("Item8", 141);
        return List.of(
                List.of(item1, item2),
                List.of(item3, item4, item5, item6),
                List.of(item6, item7),
                List.of(item8)
        );
    }
}
