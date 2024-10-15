package the_queue_at_walmart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CashierThread extends Thread {
    private int cashierId;
    private List<Items> customerItems;

    public void run() {
        AtomicInteger itemsQuantity = new AtomicInteger();
        AtomicInteger itemsPrice = new AtomicInteger();

        customerItems.forEach(item -> {
            System.out.printf("Cashier %d: %s%n", cashierId, item.getName());
            itemsPrice.addAndGet(item.getPrice());
            itemsQuantity.addAndGet(item.getPrice());
        });

        System.out.printf("Cashier %d: Total price: %d%n", cashierId, itemsPrice.get());
        System.out.printf("Cashier %d: Total quantity: %d%n", cashierId, itemsQuantity.get());
    }
}
