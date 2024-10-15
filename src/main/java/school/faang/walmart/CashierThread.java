package school.faang.walmart;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private static final int TIME_TO_WORK = 100;

    private Integer cashierId;
    private int[] customerItems;

    @Override
    public void run() {
        int totalCost = 0;
        int totalAmountItems = customerItems.length;

        System.out.println("Кассир " + cashierId + " начал обслуживание покупателя с " + totalAmountItems + " товарами.");

        for (int item : customerItems) {
            try {
                Thread.sleep(TIME_TO_WORK);
                totalCost += item;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Кассир " + cashierId + " завершил обслуживание. " +
                "Обработано товаров: " + totalAmountItems + ", общая стоимость: " + totalCost);
    }
}