package faang.school.godbless.multithreading.queue_walmart;


import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Customer> customers;

    public void acceptCustomers() {
        for (Customer customer : customers) {
            List<Item> customerItems = customer.getItems();
            int totalAmount = customerItems.stream().mapToInt(Item::getPrice).sum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Cashier: %s | Customer: %s | Total Amount: %s\n",
                    cashierId, customer.getCustomerId(), totalAmount);
        }
    }

    @Override
    public void run() {
        acceptCustomers();
    }
}
