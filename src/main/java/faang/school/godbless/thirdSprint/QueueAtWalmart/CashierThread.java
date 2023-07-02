package faang.school.godbless.thirdSprint.QueueAtWalmart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;
    private int totalCost = 0;
    private int itemsCount = 0;

    public void run() {
        System.out.println("Касса " + cashierId + " начинает обслуживать покупателя");
        for (int i = 0; i < customerItems.length; i++) {
            try {
                System.out.println("Касса " + cashierId + " пробивает товар №" + (i + 1));
                itemsCount++;
                totalCost += customerItems[i];
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Касса " + cashierId + " закончила обслуживать покупателя");
    }
}
