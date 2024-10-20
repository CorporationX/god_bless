package school.faang.queueatwalmart;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class WalmartSimulation {
    public static void main(String[] args) {
        int[][] customers = new int[10][];
        Random random = new Random();

        IntStream.range(0, customers.length).forEach(i -> {
            int itemCount = random.nextInt(10) + 1;
            customers[i] = IntStream.generate(() -> random.nextInt(20) + 1).limit(itemCount).toArray();
        });

        CashierThread[] cashiers = new CashierThread[customers.length];

        IntStream.range(0, customers.length).forEach(i -> {
            int cashierId = random.nextInt(3) + 1;
            cashiers[i] = new CashierThread(cashierId, customers[i]);
        });

        Arrays.stream(cashiers).forEach(CashierThread::start);

        Arrays.stream(cashiers).forEach(cashier -> {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted while waiting for cashier threads to finish.");
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("All customers have been processed. Thank you for shopping at Walmart!");
    }
}

