package faang.school.godbless.task.multithreading.walmart.queue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final long cashierId;
    private final Customer customer;
    private int sum;
    private final StringBuilder info = new StringBuilder();

    @Override
    public void run() {
        info.append("\ncashierId: %s, serve the customer: %s".formatted(cashierId, customer.name()));
        sum = printItemsAndGetSum();
        info.append("\nSum: %s$\n".formatted(sum));
        log.info(info.toString());
    }

    private int printItemsAndGetSum() {
        return customer
                .items()
                .stream()
                .peek(item -> info.append("\nItem: %s, cost: %s$".formatted(item.name(), item.cost())))
                .mapToInt(CustomerItem::cost)
                .sum();
    }
}
