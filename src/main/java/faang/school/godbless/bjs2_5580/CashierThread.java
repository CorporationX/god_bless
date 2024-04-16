package faang.school.godbless.bjs2_5580;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread {

    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        int itemHandleCount = 0;
        int totalPrice = 0;
        for (int item : customerItems) {
            itemHandleCount++;
            totalPrice += item;
        }
        System.out.println("Total items: " + itemHandleCount + ", Total price: " + totalPrice + ". Cashier ID: " + cashierId);
    }
}
