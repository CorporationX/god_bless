package faang.school.godbless.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    private static final int AMOUNT_CLIENTS = 9;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<CompletableFuture<Boolean>> historyOfOperations = new ArrayList<>();
        Bank sber = new Bank();
        IntStream.rangeClosed(1, AMOUNT_CLIENTS).forEach(i -> sber.addAccount(new Account(i, 1000 * i)));

        sber.printAllAccounts();
        System.out.println(sber.getTotalBalance());
        IntStream.rangeClosed(1, AMOUNT_CLIENTS).forEach(i -> {
            historyOfOperations.add(CompletableFuture.supplyAsync(() -> {
                return sber.transfer(ThreadLocalRandom.current().nextInt(1, AMOUNT_CLIENTS + 1), ThreadLocalRandom.current().nextInt(1, AMOUNT_CLIENTS + 1), 1000);
            }));
        });

        IntStream.rangeClosed(1, AMOUNT_CLIENTS).forEach(i -> {
            historyOfOperations.add(CompletableFuture.supplyAsync(() -> {
                return sber.transfer(ThreadLocalRandom.current().nextInt(1, AMOUNT_CLIENTS), ThreadLocalRandom.current().nextInt(1, AMOUNT_CLIENTS), 4000);
            }));
        });

        CompletableFuture.allOf(historyOfOperations.toArray(new CompletableFuture[0])).join();
        pool.shutdown();
        sber.printAllAccounts();
        System.out.println(sber.getTotalBalance());
    }
}
