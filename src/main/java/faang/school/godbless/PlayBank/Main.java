package faang.school.godbless.PlayBank;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 1500);
        Account account3 = new Account(3, 1750);
        Account account4 = new Account(4, 3000);
        Account account5 = new Account(5, 750);
        Account account6 = new Account(6, 800);
        ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();
        accounts.put(1, account1);
        accounts.put(2, account2);
        accounts.put(3, account3);
        accounts.put(4, account4);
        accounts.put(5, account5);
        accounts.put(6, account6);
        Bank bank = new Bank(accounts);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> transferRandom(bank));
        executor.execute(() -> transferRandom(bank));
        executor.execute(() -> transferRandom(bank));
    }

    public static void transferRandom(Bank bank) {
        while (true) {
            int from = ThreadLocalRandom.current().nextInt(1, 6);
            int to = ThreadLocalRandom.current().nextInt(1, 6);
            int amount = ThreadLocalRandom.current().nextInt(0, 100);

            boolean transferred = bank.transfer(from, to, amount);
            if (!transferred) {
                System.out.println("Bank failed to transfer " + amount + " from " + from + " | Balance:" + bank.getAccounts().get(from).getBalance());
            }
        }
    }
}
