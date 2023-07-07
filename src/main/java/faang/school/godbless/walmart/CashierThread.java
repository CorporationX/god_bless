package faang.school.godbless.walmart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CashierThread extends Thread {

    private int cashierId;
    private List<Item> customerItems;
    private int totalCost;

    public CashierThread(int id, List<Item> items) {
        this.cashierId = id;
        this.customerItems = items;
    }

    @SneakyThrows
    public void run() {
        for (var item : customerItems) {
            System.out.println("Cashier #" + cashierId + " processes " + item.getName() +
                    ", which costs " + item.getPrice() + "$...");
            Thread.sleep(3_000);
            System.out.println("Cashier #" + cashierId + ": Bling!");
            totalCost += item.getPrice();
        }
    }
}
