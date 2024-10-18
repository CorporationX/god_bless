package school.faang.task319.cashier;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;

    @Override
    public void run() {
        System.out.println("Кассир " + cashierId + " Начал обработку клиента с " + customerItems.length + " товарами");
        int totalPrice = 0;
        for (String str : customerItems) {
            try {
                totalPrice+=10;
                System.out.println("Кассир " + cashierId + " пробил товар " +str);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Кассир " + cashierId + " Закончил пробивать товары на сумму " + totalPrice);
    }
}
