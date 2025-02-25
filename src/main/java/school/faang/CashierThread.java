package school.faang;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class CashierThread extends Thread {
    private final int id;
    private final List<String> customerItems;

    public void run() {
        System.out.printf("Кассир %s начал обслуживание покупателя с товарами %s\n", id, customerItems.size());
        AtomicInteger totalPrice = new AtomicInteger();
        AtomicInteger totalQuantity = new AtomicInteger();

        customerItems
                .forEach((item) -> {
                    totalQuantity.getAndIncrement();
                    totalPrice.addAndGet(50);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Выполнение задачи было прервано");
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                });
        System.out.printf("Кассир %s закончил обслуживание покупателя. " +
                "Итоговое количество товаров %s, общая стоимость %s\n",
                id, totalQuantity, totalPrice);
    }
}
