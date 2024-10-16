package queueAtWalmart_36257;


import java.util.Arrays;
import java.util.Random;

public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    public static void main(String[] args) {
        final int COUNT_CUSTOMERS = 33;
        final int COUNT_CASHIERS = 4;

        int[][] customers = new int[COUNT_CUSTOMERS][];
        CashierThread[] cashiers = new CashierThread[customers.length];

        Random random = new Random();
        for (int i = 0; i < customers.length; i++) {
            int countItems = random.nextInt(1, 30);
            customers[i] = new int[countItems];
            for (int j = 0; j < countItems; j++) {
                int priceItem = random.nextInt(1, 5000);
                customers[i][j] = priceItem;
            }

            int cashierId = random.nextInt(COUNT_CASHIERS);
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Обслужены все покупатели.");
        System.out.println("Программа завершает работу.");
    }

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " приступил к обслуживанию покупателя с " + customerItems.length + " товарами:");
        for (int item : customerItems) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Кассир " + cashierId + " завершил обслуживание покупателя. "
                + customerItems.length + " товаров  составляет " + Arrays.stream(customerItems).sum() + "rub.");
    }
}
