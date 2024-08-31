package faang.school.godbless.PlayBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        Account volodya = new Account(1, 10);
        accounts.add(volodya);
        Account gera = new Account(2, 20);
        accounts.add(gera);
        Account ilya = new Account(3, 30);
        accounts.add(ilya);

        accounts.forEach(bank::addAccount);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                int randomFrom = new Random().nextInt(bank.getAccounts().size()) + 1;
                int randomTo;
                do  {
                    randomTo = new Random().nextInt(bank.getAccounts().size()) + 1;
                } while (randomTo == randomFrom);
                bank.transfer(randomFrom, randomTo, 5);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bank.getAccounts().forEach((id, account) -> System.out.println("id: " + id + " balance: " + account.getBalance()));
    }
}
