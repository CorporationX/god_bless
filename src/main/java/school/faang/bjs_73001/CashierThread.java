package school.faang.bjs_73001;

public class CashierThread extends Thread {
    public final int cashierId;
    public final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    public void run() {
        String cashierId = "";
        System.out.printf("Кассир %s начал обслуживание покупателя c %d товарами.%n", cashierId, customerItems.length);

        int totalItems = 0;
        int totalPrice = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * 10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Кассир %s завершил обслуживание. Обработано товаров: %d, общая стоимость: %d%n", cashierId, totalItems, totalPrice);
    }
}
