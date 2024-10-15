package school.BJS2_36252;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {

    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        int sum = 0;
        try {
            for (int item : customerItems) {
                System.out.printf("Товар %s: обработан", item);
                sum += item;
                System.out.println();
                Thread.sleep(1000);
            }
            System.out.printf("Количество товара (%d) у кассира %d обработаны. Общая сумма равна %d", customerItems.length, cashierId, sum);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}