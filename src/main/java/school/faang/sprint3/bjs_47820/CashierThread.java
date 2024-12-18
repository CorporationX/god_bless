package school.faang.sprint3.bjs_47820;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    private static final int PRICE_FOR_ONE_ITEM = 5;
    private static final int DELAY = 3000;

    private final int cashierId;
    private final int[] customerItems;

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId
                + " начал обслуживание покупателя c "
                + customerItems.length + " товарами");

        int totalPrice = 0;
        int totalItems = 0;

        for (int item : customerItems) {
            totalItems++;
            totalPrice += item * PRICE_FOR_ONE_ITEM;
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            }
        }

        System.out.println(String.format("\nКассир %s закончил облуживание покупателя\n"
                + "Количество обработанных товаров: %s\n"
                + "Цена к оплате: %s",
                cashierId, totalItems, totalPrice));
    }
}
