package school.faang.line_in_wallmart;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> customerItems;

    public void run() {
        int totalItems = 0;
        double totalPrice = 0;
        for (Item item : customerItems) {
            System.out.println("Cashier " + cashierId + " is scanning item: " + item.getName() + " it's price is: " + item.getPrice());
            totalItems++;
            totalPrice += item.getPrice();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("Exception in threads connected to sleep() method has occurred", e);
                e.printStackTrace();
            }
        }
        System.out.println("Cashier finished scanning " + totalItems + " items. Total for this purchase is: " + totalPrice);
    }
}