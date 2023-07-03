package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread {
    int cashierId;
    int[] customerItems;

    @Override
    public void run() {
        int sum = 0;
        for (int item : customerItems) {
            sum += item;
            System.out.println("Кассир " + getCashierId() + " сканирует товар " + item);
        }
        System.out.println("Кассир " + cashierId + " закончил работу, всего: " + customerItems.length + " товаров"
                + " на общую сумму: " + sum);
    }
}
