package school.faang.task_61105;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ToString
class CashierThread extends Thread {
    private final int cashierId;
    private final List<CustomerBasket> customerBaskets;

    public CashierThread(int cashierId, List<CustomerBasket> customerBaskets) {
        this.cashierId = cashierId;
        this.customerBaskets = customerBaskets;
    }

    @Getter
    private int totalCustomersProcessed;
    @Getter
    private double totalRevenue;

    public void run() {
        synchronized (System.out) {
            for (CustomerBasket basket : customerBaskets) {
                synchronized (System.out) {
                    log.info("Cashier {} processing customer {}", cashierId, basket.getId());
                    basket.printBasket();
                }

                totalCustomersProcessed++;
                totalRevenue += basket.getTotalCost();
            }
        }
    }
}