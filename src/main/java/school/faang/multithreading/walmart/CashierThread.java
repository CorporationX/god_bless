package school.faang.multithreading.walmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        int totalPrice = 0;
        for (int i : customerItems) {
            System.out.println("Кассир " + cashierId + " начал обслуживание");
            try {
                Thread.sleep(500);
                totalPrice += 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Кассир " + cashierId + " закончил пробивать " + customerItems.length + " товаров стоимостью " + totalPrice);
        }
    }
}
