package faang.school.godbless.walmart_queue;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> customerItems;
    private final PaymentTaker paymentReference;
    private final Map<String, Integer> soldItemsLogger;

    public CashierThread(int cashierId, List<Item> customerItems,
                         PaymentTaker paymentReference,
                         Map<String, Integer> soldItemsLogger) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
        this.paymentReference = paymentReference;
        this.soldItemsLogger = soldItemsLogger;
    }

    @Override
    public void run() {
        processClient();
    }

    private void processClient() {
        int totalPrice = calculateTotalPrice(customerItems);

        synchronized (paymentReference) {
            getPayment(totalPrice);
        }

        synchronized (soldItemsLogger) {
            registerAllSoldProducts(customerItems);
        }
    }

    private int calculateTotalPrice(List<Item> itemList) {
        return itemList.stream()
                .map(Item::getPrice)
                .reduce(0, Integer::sum);
    }

    private void getPayment(int bill) {
        paymentReference.addMoney(bill);
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
