package faang.school.godbless.queue_at_walmart;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] customersItems;


    public void run() {
        for(int i = 0; i < customersItems.length; i++) {
            System.out.println("Cashier" + cashierId + " put through item - " + customersItems[i]);
        }
        System.out.println("Cashier" + cashierId + " put through " + customersItems.length + " items in the amount of " + Arrays.stream(customersItems).sum());
    }
}
