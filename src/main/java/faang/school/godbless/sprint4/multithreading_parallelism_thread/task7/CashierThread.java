package faang.school.godbless.sprint4.multithreading_parallelism_thread.task7;

public class CashierThread extends Thread {
    private int cashierId;

    private int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int item : customerItems) {
            System.out.println("Кассир " + cashierId + " продает: " + item);
            sum += item;
        }
        System.out.println("Кассир " + cashierId + " продает: " + customerItems.length + " товаров. Сумма: " + sum);
    }
}
