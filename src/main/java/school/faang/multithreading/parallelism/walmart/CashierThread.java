package school.faang.multithreading.parallelism.walmart;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cachierId;
    private int[] customerItems;

    @Override
    public void run() {
        log.info("{} - Количество покупок {}, общая стоимость покупок: {}",
                Thread.currentThread().getName(),
                customerItems.length,
                Arrays.stream(customerItems).sum());
    }
}
