package faang.school.godbless.bank;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Bank bank = new Bank();
        addAccounts(bank);

        boolean transf1 = CompletableFuture.supplyAsync(()
                -> bank.transfer(bank.getAccounts().get(4), bank.getAccounts().get(5), BigDecimal.valueOf(10000)), executorService).join();
        if (!transf1) {
            System.out.println("Not enough funds on account");
        }
        boolean transf2 = CompletableFuture.supplyAsync(()
                -> bank.transfer(bank.getAccounts().get(5), bank.getAccounts().get(4), BigDecimal.valueOf(100)), executorService).join();

        executorService.shutdown();
        awaitTermination(executorService, 5);
        System.out.println(bank.getAccounts().get(4));
        System.out.println(bank.getAccounts().get(5));
        System.out.println(bank.getTotalBalance());
    }

    private static void addAccounts(Bank bank) {
        for (int i = 0; i < 10; i++) {
            bank.addAccount(new Account(i, BigDecimal.valueOf(101)));
        }
    }

    private static void awaitTermination(ExecutorService executorService, int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
