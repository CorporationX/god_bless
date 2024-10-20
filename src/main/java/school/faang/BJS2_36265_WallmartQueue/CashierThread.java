package school.faang.BJS2_36265_WallmartQueue;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class CashierThread extends Thread {
    private static final int MIN_PRICE = 5;
    private static final int MAX_PRICE = 20;

    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        AtomicInteger totalPrice = new AtomicInteger();
        AtomicInteger totalItemsAmount = new AtomicInteger();
        Arrays.stream(customerItems).forEach(itemAmount -> {
            totalItemsAmount.addAndGet(itemAmount);
            int itemPrice = ThreadLocalRandom.current().nextInt(MIN_PRICE, MAX_PRICE + 1);
            int itemTotalPrice = itemPrice * itemAmount;
            totalPrice.addAndGet(itemTotalPrice);
            System.out.printf(
                    "Cashier (id: %d) processes %d items at price %d. Total for this item: %d\n",
                    cashierId, itemAmount, itemPrice, itemTotalPrice
            );
        });
        System.out.printf("Cashier (id: %d) - total price for cheque with %d items: %d\n", cashierId, totalItemsAmount.get(), totalPrice.get());
    }
}
