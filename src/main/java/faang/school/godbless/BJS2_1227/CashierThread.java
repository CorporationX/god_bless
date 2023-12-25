package faang.school.godbless.BJS2_1227;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    List<String> customerItems;
    private int cashierId;

    @Override
    public void run() {
        processCustomerItems();
    }

    private void processCustomerItems() {
        int totalItems = 0;
        double totalCost = 0.0;

        System.out.println("Cashier " + cashierId + " is processing items.");

        for (String items : customerItems) {
            totalItems++;
            totalCost += getRandomItemCost();
        }

        System.out.printf("Cashier %d processed %d items. Total cost: $%.2f%n", cashierId, totalItems, totalCost);
    }

    private double getRandomItemCost() {
        Random random = new Random();
        return random.nextDouble() * 10 + 1;
    }
}