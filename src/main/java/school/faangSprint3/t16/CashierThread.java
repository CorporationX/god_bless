package school.faangSprint3.t16;

public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " начал обслуживание покупателя с " +
                customerItems.length + " товарами.");

        int totalItems = 0;
        int totalPrice = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * 10; // Предполагаем, что каждый товар стоит 10 единиц
            System.out.println("Кассир " + cashierId + " обрабатывает товар #" +
                    totalItems + " стоимостью " + (item * 10));

            try {
                Thread.sleep(500); // Симулируем время обработки каждого товара (0.5 секунды)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Кассир " + cashierId + " завершил обслуживание. " +
                "Обработано товаров: " + totalItems + ", общая стоимость: " + totalPrice);
    }
}