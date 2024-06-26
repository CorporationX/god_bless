package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_11_walmart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class CashierThread extends Thread {
    private final int cashierId;
    private final Customer[] customers;
    private int total = 0;

    @Override
    public void run() {
        System.out.printf("касир_%d: Принял нового клиента\n", cashierId);

        for (Customer customer : customers) {
            Item[] items = customer.items();

            for (Item item : items) {
                total += item.cost();
            }
        }
        System.out.printf("касир_%d: Обработал клиента\n", cashierId);
    }
}
