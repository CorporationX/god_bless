package school.faang.task_48207;

import lombok.ToString;

import java.util.List;

@ToString
class CashierThread extends Thread {
    private final int cashierId;
    private final List<CustomerBasket> customerBaskets;

    public CashierThread(int cashierId, List<CustomerBasket> customerBaskets) {
        this.cashierId = cashierId;
        this.customerBaskets = customerBaskets;
    }

    public void run() {
        synchronized (System.out) {
            for (CustomerBasket basket : customerBaskets) {
                System.out.printf("Cashier: %s\n", cashierId);
                basket.printBasket();
            }
        }
    }
}