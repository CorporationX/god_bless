package faang.school.godbless.spring_4.queue_at_walmart;

import java.util.List;

public class CashierThread extends Thread {
    private final int cashierId;
    private List<String> customerItems;

    public CashierThread(int cashierId, List<String> customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.printf("%s выдал товар общей стоимостью: %s \n", cashierId, getCustomerItems().size());
    }

    public int getCashierId() {
        return cashierId;
    }

    public List<String> getCustomerItems() {
        return customerItems;
    }

    public void setCustomerItems(List<String> customerItems) {
        this.customerItems = customerItems;
    }
}
