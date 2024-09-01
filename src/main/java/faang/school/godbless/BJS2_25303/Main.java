package faang.school.godbless.BJS2_25303;

import java.util.ArrayList;
import java.util.List;
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
    private static final Map<Integer, Account> accounts = generateAccounts();

    public static void main(String[] args) {
        Bank bank = new Bank(accounts);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREADS);
        IntStream.range(0, NUMS_THREADS)
                .forEach(i -> executor.scheduleAtFixedRate(() -> {
                            List<Account> transerAcc = transferAccounts();
                            bank.transfer(transerAcc.get(0), transerAcc.get(1),
                                    ThreadLocalRandom.current().nextInt(5000, 20000));
                        },
                        0, 4, TimeUnit.SECONDS));
        try {
            Thread.sleep(10_000);
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("Total balance: " + bank.getTotalBalance());
    }

    public static List<Account> transferAccounts() {
        List<Account> result = new ArrayList<>();
        Account from = accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
        Account to = from;
        while (from.equals(to)) {
            to = accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
        }
        result.add(from);
        result.add(to);
        return result;
    }

    public static Map<Integer, Account> generateAccounts() {
        return IntStream.range(0, NUMS_ACCOUNTS)
                .mapToObj(i -> new Account(i, new Random().nextInt(10000, 50000)))
                .collect(Collectors.toMap(Account::getId, Function.identity()));
    }
}
