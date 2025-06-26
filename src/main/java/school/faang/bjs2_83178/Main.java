package school.faang.bjs2_83178;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.getAccounts().put(1, new Account(1, 1000.0));
        bank.getAccounts().put(2, new Account(2, 1500.0));
        bank.getAccounts().put(3, new Account(3, 2000.0));
        bank.getAccounts().put(4, new Account(4, 3000.0));
        bank.getAccounts().put(5, new Account(5, 4000.0));

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Runnable task = () -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int fromAccountId = random.nextInt(5) + 1;
                int toAccountId = random.nextInt(5) + 1;
                double amount = random.nextDouble(500);

                if (fromAccountId != toAccountId) {
                    String threadName = Thread.currentThread().getName();
                    boolean success = bank.transfer(fromAccountId, toAccountId, amount);
                    if (success) {
                        log.info("[{}] Transfer successful: {} ➡ {} | amount: {}",
                                threadName, fromAccountId, toAccountId, String.format("%.2f", amount));
                    } else {
                        log.warn("[{}] Transfer failed: {} ➡ {} | amount: {} (insufficient funds)",
                                threadName, fromAccountId, toAccountId, String.format("%.2f", amount));
                    }
                }
            }
        };

        for (int i = 0; i < 4; i++) {
            executor.submit(task);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            log.info("Waiting for threads to finish...");
        }

        log.info("Total balance of all accounts: {}", bank.getTotalBalance());
    }
}
