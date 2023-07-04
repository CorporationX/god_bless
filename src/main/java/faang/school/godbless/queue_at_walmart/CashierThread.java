package faang.school.godbless.queue_at_walmart;

import lombok.Getter;

@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.println("Checkout number " + cashierId + " started customer service");
        for (Integer item : customerItems) {
            System.out.println("Item - " + item);
        }
        System.out.println("Checkout number " + cashierId + " finished customer service");
    }
}
