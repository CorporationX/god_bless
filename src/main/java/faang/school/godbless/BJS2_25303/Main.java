package faang.school.godbless.BJS2_25303;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMS_ACCOUNTS = 10;
    private static final int NUMS_THREADS = 20;

    public static void main(String[] args) {
        Map<Integer, Account> accounts = generateAccounts();
        Bank bank = new Bank(accounts);
        System.out.println("Begin");
        for (var entry : bank.getAccounts().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getId() + " " + entry.getValue().getBalance());
        }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREADS);

        for (int i = 0; i < NUMS_THREADS; i++) {
            Account from = accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
            Account to = from;
            while (from.equals(to)) {
                to = accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
            }
            Account finalTo = to;
//            executor.scheduleAtFixedRate(()->bank.transfer(from, finalTo, ThreadLocalRandom.current().nextInt(5000, 20000)), 0, 2, TimeUnit.SECONDS);
            executor.scheduleAtFixedRate(()->{
                bank.transfer(from, finalTo, ThreadLocalRandom.current().nextInt(5000, 20000));
            }, 0, 2, TimeUnit.SECONDS);
        }

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static Map<Integer, Account> generateAccounts() {
        return IntStream.range(0, NUMS_ACCOUNTS)
                .mapToObj(i -> new Account(i, new Random().nextInt(10000, 50000)))
                .collect(Collectors.toMap(Account::getId, Function.identity()));
    }
}
