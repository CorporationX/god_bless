package school.faang.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int COUNT_OPERATIONS = 1_000_000;
    private static final int SUM_TO_TRANSFER = 100;

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<CompletableFuture<Boolean>> futures = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(0, 1000.0));
        accounts.add(new Account(1, 1000.0));
        accounts.add(new Account(2, 1000.0));

        accounts.forEach(bank::addAccount);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for(int i = 0; i < COUNT_OPERATIONS; i++) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                int from = ThreadLocalRandom.current().nextInt(accounts.size());
                int to = 0;
                while (from == to) {
                    to = ThreadLocalRandom.current().nextInt(accounts.size());
                }
                return bank.transfer(from, to, SUM_TO_TRANSFER);
            }, executor));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();

        System.out.println(bank.getTotalBalance());
    }
}