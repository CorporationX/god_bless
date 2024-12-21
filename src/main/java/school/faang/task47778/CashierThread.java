package school.faang.task47778;

import lombok.AllArgsConstructor;

import java.util.Arrays;


@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " начал обслуживание покупателя с "
                + Arrays.toString(customerItems) + " товарами ");
        int totalItems = 0;
        int totalPrice = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * 10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Кассир " + cashierId + " завершил обслуживание. Обработано товаров"
                + totalItems + " общая стоимость " + totalPrice);
    }
}
