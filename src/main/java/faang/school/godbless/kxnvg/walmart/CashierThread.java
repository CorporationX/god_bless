package faang.school.godbless.kxnvg.walmart;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {

    private int cashierId;
    private int[] customerItems;
    private int itemsNumber;
    private int totalCost;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.println("Касса №" + cashierId + " начала обсуживание клиента");
        for (Integer item : customerItems) {
            totalCost += item;
            itemsNumber++;
        }
        System.out.println("Касса №" + cashierId + " закончила обслуживание клиента");
    }
}
