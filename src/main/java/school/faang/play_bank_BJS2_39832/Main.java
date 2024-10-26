package school.faang.play_bank_BJS2_39832;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AWAITING_TIME = 3;
    private static final int OPERATIONS_COUNT = 10;

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>(List.of(new Account(1, 1500.50),
                new Account(2, 2500.00), new Account(3, 350.75),
                new Account(4, 4600.90), new Account(5, 1250.30)
        ));

        Bank bank = new Bank();
        Random random = new Random();
        ExecutorService executor = Executors.newCachedThreadPool();

        accounts.forEach(bank::addAccount);
        System.out.println("Total balance " + bank.getTotalBalance());

        for (int i = 0; i < OPERATIONS_COUNT; i++) {
            executor.submit(() -> {
                int randomFrom = 1;
                int randomTo = accounts.size();
                double randomAmountTo = 1000;

                double amount = random.nextDouble(randomAmountTo);
                int fromAccount = random.nextInt(randomFrom, randomTo);
                int toAccount = random.nextInt(randomFrom, randomTo);

                System.out.println(bank.transfer(fromAccount, toAccount, amount) ? "Transfer successful" :
                        "Transfer declined");
            });
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Total balance: " + bank.getTotalBalance());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}