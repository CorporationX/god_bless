package faang.school.godbless.multithreading.queue_walmart;


import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[] items;

    @Override
    public void run() {
        int totalAmount = Arrays.stream(items).sum();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("CashierId: %s | Total Amount: %s\n", cashierId, totalAmount);
    }
}
