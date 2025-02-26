package school.faang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private final int id;
    private final String[] customerItems;

    public void run() {
        System.out.printf("Кассир %s начал обслуживание покупателя с товарами %s\n", id, customerItems.length);
        int totalPrice = 0;
        int totalQuantity = 0;


        for (int i = 0; i < customerItems.length; i++) {
            totalPrice += 50;
            totalQuantity += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Выполнение задачи было прервано");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.printf("Кассир %s закончил обслуживание покупателя. " +
                "Итоговое количество товаров %s, общая стоимость %s\n",
                id, totalQuantity, totalPrice);
    }
}
