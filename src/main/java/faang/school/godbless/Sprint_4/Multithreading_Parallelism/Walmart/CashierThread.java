package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Walmart;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> customerItems;

    public void run() {
        int sum = 0;
        for(Item i : customerItems) {
            System.out.printf("Обработан товар %s на кассе: %d\n", i.getName() + 1, cashierId);
            sum += i.getPrice();
        }
        System.out.printf("Стоимость товаров на кассе %d: %d\n", cashierId + 1, sum);
    }
}
