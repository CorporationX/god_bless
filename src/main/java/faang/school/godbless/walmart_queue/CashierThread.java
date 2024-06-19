package faang.school.godbless.walmart_queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> customerItems;
    private AtomicInteger paymentReference;
    private ConcurrentHashMap<String, Integer> soldItemsLogger;

    @Override
    public void run() {
        processClient();
    }

    private void processClient() {
        int totalPrice = calculateTotalPrice(customerItems);

        getPayment(totalPrice);

        registerAllSoldProducts(customerItems);
    }

    private int calculateTotalPrice(List<Item> itemList) {
        return itemList.stream()
                .map(Item::getPrice)
                .reduce(0, Integer::sum);
    }

    private void getPayment(int bill) {
        paymentReference.addAndGet(bill);
    }

    private void registerAllSoldProducts(List<Item> itemList) {
        itemList.forEach(item -> {
                    String itemName = item.getName();

                    if (!soldItemsLogger.containsKey(itemName)) {
                        soldItemsLogger.put(itemName, 1);
                    } else {
                        int currentSoldItemNumber = soldItemsLogger.get(itemName);
                        soldItemsLogger.put(itemName, currentSoldItemNumber + 1);
                    }
                }
        );
    }
}
