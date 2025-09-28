package school.faang.bjs2_93325;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int SIZE_POOL_THREAD = 10;
    private static final int MIN_BALANCE = 10_000;
    private static final int MAX_BALANCE = 100_000;
    private static final int MIN_TRANSFER = 500;
    private static final int MAX_TRANSFER = 5_000;
    private static final int SLEEP_WAITING = 30;
    private static final int TOTAL_ACCOUNT = 20;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Bank bank = new Bank();
        ExecutorService executor = Executors.newFixedThreadPool(SIZE_POOL_THREAD);

        List<Integer> accountIds = IntStream.rangeClosed(1, TOTAL_ACCOUNT).mapToObj(i -> {
            Account account = new Account(GenerateId.getId(), random.nextDouble(MIN_BALANCE, MAX_BALANCE));
            bank.addAccount(account);
            return account.getId();
        }).toList();

        accountIds.stream().reduce((prevId, currentId) -> {
            executor.submit(() ->
                    bank.transfer(prevId, currentId, random.nextDouble(MIN_TRANSFER, MAX_TRANSFER)));
            return currentId;
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(SLEEP_WAITING, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        bank.getTotalBalance();
    }
}
