package school.faang.sprint3.bjs_47820;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    private static final int PRICE_FOR_ONE_ITEM = 5;
    private static final Random RANDOM = new Random();

    private final int cashierId;
    private final int[] customerItems;

    public static void main(String[] args) throws InterruptedException {
        int[][] customers = {
                {5, 7, 3, 2},
                {1, 2, 3},
                {6, 5, 2},
                {10, 2, 1, 3, 5}
        };

        int countCashiers = 3;

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            int cashierId = RANDOM.nextInt(countCashiers) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            cashier.join();
        }

        System.out.println("Все кассиры завершили работу.");
    }

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
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Кассир " + cashierId + " закончил облуживание покупателя\n"
                + "Количество обработанных товаров:" + totalItems + "\n"
                + "Цена к оплате:" + totalPrice);
    }
}
