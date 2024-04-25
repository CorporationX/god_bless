package faang.school.godbless.sprint_3.queue_in_walmart;

import java.util.List;

public class CashierThread extends Thread {
    private int cashierId;
    private List<String> customerItems;

    public CashierThread(int cashierId, List<String> customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    public void run() {
        customerItems.forEach(System.out::println);
    }
}