package school.faang.bjs2_72998;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Getter
@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        log.info("Cashier with id {} started processing", cashierId);
        Arrays.stream(customerItems)
                .forEach(item -> log.info("Item with price {} processed", item));
        int count = customerItems.length;
        int sum = Arrays.stream(customerItems)
                .sum();
        log.info("Items count: {}, items sum price: {}", count, sum);
        log.info("Cashier with id {} finished processing", cashierId);
    }
}