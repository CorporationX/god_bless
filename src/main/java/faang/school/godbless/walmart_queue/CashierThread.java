package faang.school.godbless.walmart_queue;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " пробил следующее количество товаров: " + customerItems.length + "\n" +
                "Общая стоимость покупки составила: " + Arrays.stream(customerItems).sum() + " рублей");
    }
}
