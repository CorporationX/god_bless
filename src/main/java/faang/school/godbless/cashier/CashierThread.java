package faang.school.godbless.cashier;

import java.util.Arrays;

public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " начинает обслуживание покупателя...");

        try {
            double totalPrice = Arrays.stream(customerItems)
                    .peek(item -> {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Кассир " + cashierId + " был прерван во время обработки.");
                        }
                    })
                    .sum();

            System.out.println("Кассир " + cashierId + " закончил обслуживание покупателя. Общая стоимость: $" + totalPrice);

        } catch (Exception e) {
            System.out.println("Кассир " + cashierId + " завершил работу с ошибкой: " + e.getMessage());
        }
    }
}

