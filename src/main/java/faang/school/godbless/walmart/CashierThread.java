package faang.school.godbless.walmart;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private String[] customerItems;

    @Override
    public void run() {
        for (String customerItem : customerItems) {
            System.out.println("Cashier " + cashierId + ": " + customerItem);
        }
    }
}
