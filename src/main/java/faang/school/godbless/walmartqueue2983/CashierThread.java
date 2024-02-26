package faang.school.godbless.walmartqueue2983;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;
    private List<String> scannedItems;
    @Setter private double dollarsEarned;

    public CashierThread(int cashierId, String[] customerItems, List<String> scannedItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
        this.scannedItems = scannedItems;
    }

    @Override
    public void run() {
        String[] unhandledCustomerItems = this.getCustomerItems();
        Random random = new Random();

        for (int i = 0; i < this.getCustomerItems().length; i++) {
            if (unhandledCustomerItems[i] != null) {
                double price = random.nextDouble(1.00, 5.00);
                this.getScannedItems().add(unhandledCustomerItems[i]);
                System.out.printf("Beep-Beep. %s scanned.%n", unhandledCustomerItems[i]);
                unhandledCustomerItems[i] = null;
                this.setDollarsEarned(this.getDollarsEarned() + price);
            }
        }
        System.out.println("Customer is served. Next!");
    }

    @Override
    public String toString() {
        return String.format("""
                Cashier %d:
                Total money earned - %.2f$
                Item scanned: %s
                Quantity of scanned items: %d
                """, this.getCashierId(), this.getDollarsEarned(), this.getScannedItems(), this.getScannedItems().size());
    }
}
