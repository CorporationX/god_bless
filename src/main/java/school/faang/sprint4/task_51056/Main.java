package school.faang.sprint4.task_51056;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 4;
    private static final int NUM_TASKS = 40;

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

        Random random = new Random();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        List<CompletableFuture<Void>> futures = IntStream.range(0, NUM_TASKS)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    int fromAccountId = random.nextInt(4) + 1;
                    int toAccountId = random.nextInt(4) + 1;
                    double amount = random.nextInt(500);

                    if (fromAccountId != toAccountId) {
                        bank.transfer(fromAccountId, toAccountId, amount);
                    }
                }, pool))
                .toList();

        pool.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total balance: " + bank.getTotalBalance());

        try {
            if (!pool.awaitTermination(30, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
