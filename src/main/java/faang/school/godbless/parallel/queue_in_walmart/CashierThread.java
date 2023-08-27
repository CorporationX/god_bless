package faang.school.godbless.parallel.queue_in_walmart;

public class CashierThread extends Thread {
    private int cashierId;
    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int totalItems = 0;
        double totalPrice = 0;
        for (int item : customerItems) {
            totalItems++;
            totalPrice += item;
            System.out.println(Thread.currentThread().getName() + " thread | Cashier " + cashierId + " processed item: " + item);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " thread | Cashier " + cashierId + " processed " + totalItems + " items with a total price of " + totalPrice);
    }
}