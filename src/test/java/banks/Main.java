package banks;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_COUNT = 3;
    private final static Random random = new Random();

    public static void main(String[] args) {
        Account account1 = new Account(1, 2000.0);
        Account account2 = new Account(2, 3000.0);
        Account account3 = new Account(3, 4000.0);
        Account account4 = new Account(4, 2500.0);
        Bank bank = new Bank();
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            for (int j = 0; j < 10; j++) {
                int fromAccountId = random.nextInt(4) + 1;
                int toAccountId = random.nextInt(4) + 1;
                double amound = random.nextInt(500);
                if (fromAccountId != toAccountId) {
                    executorService.submit(() -> bank.transfer(fromAccountId, toAccountId, amound));
                }
            }
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("Bank total balance: " + bank.getTotalbalance());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
