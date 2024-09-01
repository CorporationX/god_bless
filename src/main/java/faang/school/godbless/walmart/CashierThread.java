package faang.school.godbless.walmart;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CashierThread extends Thread {

    private final int cashierId;
    private final int[] customerItems;

    public void run() {
        System.out.println(cashierId + " is busy");
        int countItems = 0;
        int totalPrice = 0;
        for (Integer customerItem : customerItems) {
            totalPrice += customerItem;
            countItems++;
        }
        System.out.println("Number of products " + countItems + ". Total: " + totalPrice);
        System.out.println(cashierId + " is free");
    }
}
