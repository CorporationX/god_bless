package faang.school.godbless.BJS2_25269;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CORE_POOL_SIZE = 5;
    private static final long DELAY = 3;
    private static final long DURATION = 100;


    public static void main(String[] args) {
        List<Account> accounts = Arrays.asList(
                new Account(1, 100),
                new Account(2, 300),
                new Account(3, 550),
                new Account(4, 50)
        );

        Bank bank = new Bank();
        accounts.forEach(bank::addAccount);
        Random random = new Random();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        executor.scheduleAtFixedRate((() -> generateTransfer(accounts, bank, random)), 0, DELAY, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate((() -> generateTransfer(accounts, bank, random)), 0, DELAY, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate((() -> generateTransfer(accounts, bank, random)), 0, DELAY, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(() ->
                System.out.println("Total balance: " + bank.getTotalBalance()), 0, DELAY, TimeUnit.SECONDS);
        executor.schedule(executor::shutdown, DURATION, TimeUnit.SECONDS);
    }

    public static void generateTransfer(List<Account> accounts, Bank bank, Random random) {
        Account fromAccount = accounts.get(random.nextInt(accounts.size()));
        Account toAccount = accounts.get(random.nextInt(accounts.size()));
        int transferMoney = (1 + random.nextInt(3)) * 10;
        if (!fromAccount.equals(toAccount)) {
            if (bank.transfer(fromAccount, toAccount, transferMoney)) {
                System.out.println(fromAccount + " -> " + toAccount + ": " + transferMoney);
            } else {
                System.out.println(fromAccount + " -> " + toAccount + ": X");
            }
        }
    }
}
