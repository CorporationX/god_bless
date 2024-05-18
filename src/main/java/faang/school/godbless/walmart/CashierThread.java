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
        int sumItems = 0;
        for (int customerItem : customerItems) {
            sumCost += customerItem;
            sumItems += 1;
        }
        System.out.println("Items " + sumItems + " Total " + sumCost);
    }
}
