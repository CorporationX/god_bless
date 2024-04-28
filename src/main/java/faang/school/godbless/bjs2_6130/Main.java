package faang.school.godbless.bjs2_6130;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Account vasya = new Account(1, 5000);
        Account ira = new Account(2, 10000);
        Account misha = new Account(3, 7500);

        bank.addAccount(vasya);
        bank.addAccount(ira);
        bank.addAccount(misha);

        System.out.println("Total bank balance: " + bank.getTotalBalance());

        //Random transfer operations
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<CompletableFuture<Boolean>> futures = IntStream.range(0, NUM_THREADS).mapToObj(num -> CompletableFuture.supplyAsync(() -> {
            int[] ids = new Random().ints(1, 4).distinct().limit(2).toArray();
            int transferSum = new Random().nextInt(2000, 7000);
            log.info("Transfer from {} to {} sum = {}", ids[0], ids[1], transferSum);
            return bank.transfer(ids[0], ids[1], transferSum);
        }, executorService)).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        bank.printAllAccounts();
        System.out.println("Total bank balance: " + bank.getTotalBalance());
    }
}
