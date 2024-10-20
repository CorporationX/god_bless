package school.faang.godbless.bjs2_36266;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CashierThread extends Thread {
    private final String cashierId;
    private final List<Item> customerItems;
    @Getter
    private int totalPrice = 0;
    @Getter
    private int processedItemsCount = 0;

    public CashierThread(String id, List<Item> items) {
        super();
        this.cashierId = id;
        this.customerItems = new ArrayList<>();
        customerItems.addAll(items);
    }

    @Override
    public void run() {
        customerItems.forEach(item -> {
            log.info("Cashier {} processing item {}", cashierId, item);
            totalPrice += item.getPrice();
            processedItemsCount++;
        });
        log.info("Cashier {} processed all items. Number of items: {} Total price: {}", cashierId, processedItemsCount, totalPrice);
    }
}
