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
    private static Map<Integer, Account> accounts = generateAccounts();

    public static void main(String[] args) {
        Bank bank = new Bank(accounts);
        System.out.println("Begin");
        for (var entry : bank.getAccounts().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getId() + " " + entry.getValue().getBalance());
        }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREADS);
//        bank.transfer(bank.getAccounts().get(1),bank.getAccounts().get(2),1000);
        IntStream.range(0, NUMS_THREADS)
                .forEach(i -> {
                    executor.scheduleAtFixedRate(() -> {
                                List<Account> transerAcc = transferAccounts();
                                bank.transfer(transerAcc.get(0), transerAcc.get(1),
                                        ThreadLocalRandom.current().nextInt(5000, 20000));
//                                        1000);
                            },
                            0, 4, TimeUnit.SECONDS);
                });


//        for (int i = 0; i < NUMS_THREADS; i++) {
//            Account from = accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
//            Account to = from;
//            while (from.equals(to)) {
//                to = accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
//            }
//            Account finalTo = to;
//            executor.scheduleAtFixedRate(() -> {
//                bank.transfer(from, finalTo, ThreadLocalRandom.current().nextInt(5000, 20000));
//            }, 0, 4, TimeUnit.SECONDS);
//        }
        try {
            Thread.sleep(20_000);
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
