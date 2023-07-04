package faang.school.godbless.walmart_queue;

import lombok.Getter;

import java.util.List;

@Getter

public class CashierThread extends Thread {

    private int cashierId;
    private List<Item> customerItems;
    private int totalCost;
    private int totalItems;

    public CashierThread(int cashierId, List<Item> customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        for (Item item : customerItems) {
            System.out.println("Cashier №" + cashierId + " scans the " + item.getName());

            try {
                Thread.sleep(500);
                totalCost += item.getPrice();
                totalItems++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Cashier №" + cashierId + " scanned " + totalItems + " items, total cost is " + totalCost);
        }

        System.out.println(
                "Cashier №" + cashierId + "  have processed in total " + totalItems + " items, total cost of which equals to " + totalCost);
    }
}
