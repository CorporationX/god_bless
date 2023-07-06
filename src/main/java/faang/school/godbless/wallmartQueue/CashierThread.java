package faang.school.godbless.wallmartQueue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;
    private int numberOfItems;
    private int totalCost;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        for (int item : customerItems) {
            totalCost += item;
            numberOfItems++;
        }
    }
}
