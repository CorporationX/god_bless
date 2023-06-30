package faang.school.godbless.walmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        int sumCost = 0;
        for (int customerItem : customerItems) {
            sumCost += customerItem;
            System.out.println(customerItem);
        }
        System.out.println("total " + sumCost);
    }
}
