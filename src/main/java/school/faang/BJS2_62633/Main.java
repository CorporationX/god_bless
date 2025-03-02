package school.faang.BJS2_62633;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final Random random = new Random();
    private static final int THREADS_AMOUNT = 5;
    private static final int ACCOUNT_BALANCE_MIN = 100;
    private static final int ACCOUNT_BALANCE_MAX = 1_000 + 1;
    private static final int ACCOUNTS_AMOUNT = 100 + 1;
    private static final double AMOUNT_MIN = 50;
    private static final double AMOUNT_MAX = 100 + 1;
    private static final int TERMINATION_TIME = 5;
    private static final int TASKS_AMOUNT = 100;

    public static void main(String[] args) {
        Bank bank = new Bank();
        IntStream.range(0, TASKS_AMOUNT)
                .forEach(i -> bank.addAccount(
                        new Account(i, random.nextInt(ACCOUNT_BALANCE_MIN, ACCOUNT_BALANCE_MAX))));

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);

        IntStream.range(0, THREADS_AMOUNT)
                .forEach(i -> executor.submit(() -> bank.transfer(random.nextInt(1, ACCOUNTS_AMOUNT),
                        random.nextInt(1, ACCOUNTS_AMOUNT),
                        random.nextDouble(AMOUNT_MIN, AMOUNT_MAX))));

        executor.shutdown();

        try {
            if (executor.awaitTermination(TERMINATION_TIME, TimeUnit.SECONDS)) {
                System.out.println("All tasks finished withing 5 second");
            } else {
                System.out.println("Not all tasks finished within 5 second");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Waiting for all tasks to complete was interrupted");
        }

        if (!executor.isTerminated()) {
            System.out.println("Force quit remaining tasks");
            executor.shutdownNow();
        }

        System.out.println(bank.getTotalBalance());
    }
}

