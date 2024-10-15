package the_queue_at_walmart;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@EqualsAndHashCode(callSuper = true)
public class CashierThread extends Thread {
    private int cashierId;
    private List<Items> customerItems;
    private int itemsPrice = 0;
    private int itemsQuantity = 0;

    public CashierThread(int cashierId, List<Items> customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    /**
     * Processes the customer items on the cashier.
     * <p>
     * The {@link #customerItems} are processed and the total price and total quantity
     * are printed.
     */
    public void run() {
        customerItems.forEach(item -> {
            System.out.printf("Cashier %d: %s%n", cashierId, item.getName());
            itemsPrice += item.getPrice();
            itemsQuantity += item.getQuantity();
        });
    }
}
