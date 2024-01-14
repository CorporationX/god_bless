package faang.school.godbless.BJS2_1227;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    private List<Item> customerItems;
    private int cashierId;

    @Override
    public void run() {
        int totalItems = 0;
        double totalCost = 0.0;

        System.out.println("Cashier " + cashierId + " is processing items.");

        for (Item item : customerItems) {
            totalItems++;
            totalCost += item.getPrice();
        }

        System.out.printf("Cashier %d processed %d items. Total cost: $%.2f%n", cashierId, totalItems, totalCost);
    }
}