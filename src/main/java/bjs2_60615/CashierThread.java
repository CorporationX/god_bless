package bjs2_60615;

public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.printf("Кассир %d начал обслуживание покупателя с %d товарами%n", cashierId, customerItems.length);

        int processedItemsCount = 0;
        int totalPrice = 0;

        for (int i = 0; i < customerItems.length; i++) {
            int item = customerItems[i];

            processedItemsCount++;
            totalPrice += item * 2; // Пусть каждые товар стоит 2 у.е.

            System.out.printf("Кассир %d обработал товар #%d%n", cashierId, i + 1);

            try {
                Thread.sleep(500); // Симулируем время обработки каждого товара (0.5 секунды)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        System.out.printf(
                "Кассир %d обработал %d товаров с общей стоимостью %d у.е.%n",
                cashierId,
                processedItemsCount,
                totalPrice);
    }
}
