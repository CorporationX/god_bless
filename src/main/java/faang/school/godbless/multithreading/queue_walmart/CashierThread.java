package faang.school.godbless.multithreading.queue_walmart;


import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private int[][] customers;

    @Override
    public void run() {
        for (int i = 0; i < customers.length; i++) {
            int totalAmount = Arrays.stream(customers[i]).sum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("CashierId: %s | CustomerId: %s | Total Amount: %s\n", cashierId, i, totalAmount);
        }
    }
}
