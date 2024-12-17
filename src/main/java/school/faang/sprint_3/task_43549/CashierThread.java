package school.faang.sprint_3.task_43549;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@EqualsAndHashCode(callSuper = true)
public class CashierThread extends Thread {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private static final int SLEEP_TIME = 3000;

    private long cashierId;
    private List<Item> customerItems;

    public CashierThread(List<Item> customerItems) {
        this.cashierId = idGenerator.incrementAndGet();
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int totalCost = 0;
        System.out.println("Кассир " + cashierId + " обрабатывает товары: " + "\n\t " + customerItems);
        for (Item item : customerItems) {
            totalCost += item.cost();
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время сна");
            }
        }
        System.out.println("Кассир " + cashierId + " обрабатал всего товаров: " + customerItems.size()
                + "\n\tОбщая стоимость: " + totalCost);
    }
}
