package school.faang.spring3.task_47759;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class CashierThread implements Runnable {
    private int cashierId;
    private BlockingQueue<Product[]> customerQueue;

    public CashierThread(int cashierId) {
        this.cashierId = cashierId;
        this.customerQueue = new LinkedBlockingQueue<>();
    }

    public void addCustomer(Product[] customerItems) {
        customerQueue.add(customerItems);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Product[] customerItems = customerQueue.take();
                processCustomer(customerItems);
            }
        } catch (InterruptedException e) {
            System.out.println("Cashier " + cashierId + " has finished work.");
        }
    }

    private void processCustomer(Product[] customerItems) {
        System.out.println("Cashier " + cashierId + " started serving a customer.");
        double totalCost = 0;

        for (Product item : customerItems) {
            System.out.println("Cashier " + cashierId + " processed item: " + item.getName()
                    + " ($" + item.getPrice() + ")");
            totalCost += item.getPrice();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("smth went wrong");
            }
        }

        System.out.println("Cashier " + cashierId + " finished serving a customer. Total items: "
                + customerItems.length + ", Total cost: $" + totalCost);
    }
}