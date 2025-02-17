package school.faang;

import java.util.Random;

public class CashierThread extends Thread{
    private static final Random random = new Random();
    private static final int MIN_SLEEP_TIME = 1000;
    private static final int MAX_SLEEP_TIME = 3000;
    private final int cashierId ;
    private final int[] customerItems;

    public CashierThread(int cashierId , int[] customerItems) {
        this.cashierId  = cashierId ;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Cashier with id %d started servicing the customer with %d products \n",
                    cashierId, customerItems.length);
            Thread.sleep(MIN_SLEEP_TIME + random.nextInt(MAX_SLEEP_TIME));
            System.out.printf("Cashier with id %d finished servicing the customer with %d products \n",
                    cashierId, customerItems.length);
        } catch (InterruptedException e) {
            System.out.printf("Cashier with id %d failed servicing the customer with %d products \n",
                    cashierId, customerItems.length);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
