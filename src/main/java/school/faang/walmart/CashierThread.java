package school.faang.walmart;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private static final int PROCESSING_TIME_MS = 500;
    private static final int PRICE_PER_ITEM = 10;

    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        System.out.printf("Кассир #%d начинает обслуживать покупателя.", cashierId);

        int totalItems = 0;
        for (int item : customerItems) {
            totalItems++;
            System.out.printf("Кассир #%d обрабатывает товар %d%n", cashierId, item);
            try {
                Thread.sleep(PROCESSING_TIME_MS);
            } catch (InterruptedException e) {
                System.out.printf("Кассир #%d был прерван во время работы.", cashierId);
                return;
            }
        }
        int totalCost = totalItems * PRICE_PER_ITEM;
        System.out.printf("Кассир #%d завершил обслуживание. Обработано товаров: %d. Общая стоимость: %d рублей.%n",
                cashierId, totalItems, totalCost);
    }
}
