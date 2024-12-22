package school.faang.sprint_3.task_47738;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class CashierThread extends Thread {
    private static final int ITEM_PROCESSING_DELAY = 5000;

    private final int cashierId;
    @NonNull
    private final List<Item> customerItems;

    @Override
    public void run() {
        System.out.printf("Cashier %s starts processing\n", cashierId);
        Integer totalPrice = customerItems.stream()
                .peek(item -> {
                    System.out.printf("Cashier %s processing item %s, with price %s\n",
                            cashierId,
                            item.name(),
                            item.price());
                    try {
                        Thread.sleep(ITEM_PROCESSING_DELAY);
                    } catch (InterruptedException e) {
                        System.out.printf("Processing of %s interrupted\n", item.name());
                        Thread.currentThread().interrupt();
                    }
                })
                .map(Item::price)
                .reduce(Integer::sum)
                .orElse(0);

        System.out.printf("""
                Cashier %s ends processing);"
                All items processed.
                Amount of items - %d
                Total price %d
                """, cashierId,
                customerItems.size(),
                totalPrice);
    }
}
