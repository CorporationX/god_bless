package school.faang;

import bjs262619.Account;
import bjs262619.Bank;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account acc1 = new Account(1, 1000.0);
        Account acc2 = new Account(2, 2000.0);
        Account acc3 = new Account(3, 3000.0);
        Account acc4 = new Account(4, 4000.0);
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.addAccount(acc4);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable task = () -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int fromAccountId = random.nextInt(4) + 1;
                int toAccountId = random.nextInt(4) + 1;
                double amount = random.nextInt(500);
                if (fromAccountId != toAccountId) {
                    bank.transfer(fromAccountId, toAccountId, amount);
                }
            }
        };
        for (int i = 0; i < 4; i++) {
            executorService.submit(task);
        }
        shutDownExecutorService(executorService);
        log.info("Общий баланс всех счетов: {}", bank.getTotalBalance());
    }

    private static void shutDownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
