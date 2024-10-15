package school.faang.walmart.maincode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public void run() {
        int totalItems = 0;
        int totalCost = 0;

        for (int item : customerItems) {
            totalItems++;
            totalCost += item * 20;
        }
        System.out.println("Кассир " + cashierId + " обработал количество товаров " + totalItems +
                " общая цена " + totalCost);
    }
}
