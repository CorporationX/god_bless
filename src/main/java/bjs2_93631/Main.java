package bjs2_93631;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization org = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            int id = i;
            double amount = id * 100;
            executor.submit(() -> org.addDonation(new Donation(id, amount)));
        }

        ExecutorUtils.gracefullyShutdown(executor);

        System.out.printf("Итоговый баланс организации: %.2f%n", org.getBalance());
    }
}