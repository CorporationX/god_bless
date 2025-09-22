package school.faang.bjs2_89998;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> customerItems;

    @Override
    public void run() {
        for (Item item : customerItems) {
            log.debug("{} {} руб.", item.getName(), item.getPrice());
        }
        int totalSum = customerItems.stream()
                .map(Item::getPrice)
                .mapToInt(Integer::intValue)
                .sum();
        log.debug("Итого с вас {} руб за {} товаров.", totalSum, customerItems.size());
    }
}
