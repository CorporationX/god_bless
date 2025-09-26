package school.faang.bjs2_89989;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    public static final int STANDARD_PRODUCT_PRICE = 100;

    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        System.out.printf("Кассир %d начал обслуживать покупателя с %d товарами.%n", cashierId, customerItems.length);

        int totalProduct = 0;
        int totalPrice = 0;

        for (int product : customerItems) {
            totalProduct++;
            totalPrice += product * STANDARD_PRODUCT_PRICE;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Кассир %d закончил. Обработано товаров: %d на стоимость: %d.%n",
                cashierId, totalProduct, totalPrice);
    }
}