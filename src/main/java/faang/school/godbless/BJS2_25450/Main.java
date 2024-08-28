package faang.school.godbless.BJS2_25450;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<Account> accounts = List.of(
                new Account("Robert", 1, 1000),
                new Account("Mikhail", 2, 2300),
                new Account("Denis", 3, 200),
                new Account("Sultan", 4, 500),
                new Account("Shama", 5, 1200)
        );
        accounts.forEach(account ->
                bank.putAccount(account.getId(), account));

        ExecutorService executor = Executors.newFixedThreadPool(accounts.size());
        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                boolean isSuccess = bank.transfer(
                        accounts.get(random.nextInt(0, accounts.size())),
                        accounts.get(random.nextInt(0, accounts.size())),
                        random.nextInt(1, 1000)
                );

                if (isSuccess) {
                    System.out.println("transfer success");
                } else {
                    System.out.println("transfer failed");
                }
            }
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println();
        System.out.println(bank.getAccounts());
        System.out.println(bank.getTotalBalance());
    }
}
