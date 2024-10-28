package school.faang.playbank;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        double[] initialBalances = {1000.0, 1500.0, 2000.0};
        for (int i = 0; i < initialBalances.length; i++) {
            bank.addAccount(new Account(i + 1, initialBalances[i]));
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                int fromId = random.nextInt(3) + 1;
                int toId = random.nextInt(3) + 1;
                double amount = random.nextInt(500) + 100;

                performTransfer(bank, fromId, toId, amount);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Total bank balance: " + bank.getTotalBalance());
    }

    private static void performTransfer(Bank bank, int fromId, int toId, double amount) {
        if (fromId != toId) {
            boolean success = bank.transfer(fromId, toId, amount);
            if (success) {
                System.out.println("Transfer successful: $" + amount + " from Account " + fromId + " to Account " + toId);
            } else {
                System.out.println("Transfer failed: Insufficient funds on Account " + fromId);
            }
        } else {
            System.out.println("Transfer skipped: Source and destination accounts are the same.");
        }
    }
}

