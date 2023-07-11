package faang.school.godbless.multithreading.parallelism_thread.walmart;

public class CashierThread extends Thread {
    private int cashierId;
    private int[] customersItem;

    public CashierThread(int cashierId, int[] customersItem) {
        super();
        this.cashierId = cashierId;
        this.customersItem = customersItem;
    }

    @Override
    public void run() {
        System.out.println("Cashier № " + cashierId + " start to serve customer");
        try {
            Thread.sleep(1000L * customersItem.length);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cashier № " + cashierId + " has finished serve customer");

        int sum = 0;
        for (int id : customersItem) {
            sum += Item.getById(id).getPrice();
        }

        System.out.println("Cashier № " + cashierId
                + "\n Quantity of goods: " + customersItem.length
                + "\n Total cost: " + sum);
    }
}
