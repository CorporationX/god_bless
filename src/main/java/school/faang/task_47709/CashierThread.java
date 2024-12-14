package school.faang.task_47709;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CashierThread extends Thread {
    private final long id;
    private List<Customer> customers = new ArrayList<>();

    public CashierThread(long cashierId) {
        this.id = cashierId;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public synchronized void run() {
        System.out.println("Start processing at cashier " + id);
        double totalSum = 0;
        for (Customer customer : customers) {
            System.out.println("Processing customer...");
            for (int i = 0; i < customer.items().length; i++) {
                System.out.printf("Item %d costs %.3f\n", i + 1, customer.items()[i]);
                totalSum += customer.items()[i];
            }
        }
        System.out.println("End! Total sum processed by cashier " + id + ": " + totalSum);
    }
}