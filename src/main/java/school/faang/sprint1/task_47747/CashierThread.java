package school.faang.sprint1.task_47747;

import lombok.RequiredArgsConstructor;


public class CashierThread extends Thread  {
    private int cashierId;
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int delay = 2000;
        int totalItem = 0;
        int sizePurchase = customerItems.length;
        System.out.println("Кассир " + cashierId + " начал обслуживать покупателя");
        for (int i = 0; i < customerItems.length; i++) {
            System.out.println(customerItems[i]);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalItem += customerItems[i];
            System.out.println("Товар " + (i + 1) + " стоит " + customerItems[i]);

        }
        System.out.println("Кассир " + cashierId + " обслужил покупателя");
        System.out.println("обшее колличество товара " + totalItem);
    }
}
