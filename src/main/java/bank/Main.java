package bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 0; i < 5; i++) {
            bank.addAccount(new Account(ThreadLocalRandom.current().nextDouble(10_000, 100_000)));
        }

        for (int i = 0; i < 20; i++) {
            SERVICE.execute(() ->
                    {
                        Account account1 = bank.getAccounts().get(ThreadLocalRandom.current().nextInt(1, 5));
                        Account account2 = bank.getAccounts().get(ThreadLocalRandom.current().nextInt(1, 5));
                        if (bank.transfer(account1, account2, ThreadLocalRandom.current().nextDouble(5_000, 10_000))) {
                            System.out.println("Transfer is successful");
                        } else {
                            System.out.println("Transfer failed");
                        }
                    }
            );
        }
        SERVICE.shutdown();
    }
}
