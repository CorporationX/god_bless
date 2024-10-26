package school.BJS2_39851;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int SIZE_OF_THREADS = 30;
    private static final int MAX_SUM_OF_TRANSACTION = 1000;
    private static final int COUNT_OF_ACCOUNTS = 50;

    public static void main(String[] args) {

        Bank bank = new Bank();
        Random rand = new Random();

        for (int i = 0; i < COUNT_OF_ACCOUNTS; i++) {
            bank.addAccounts(i, new Account(i, rand.nextInt(MAX_SUM_OF_TRANSACTION)));
        }
        ExecutorService service = Executors.newFixedThreadPool(SIZE_OF_THREADS);

        for (int i = 0; i < SIZE_OF_THREADS; i++) {
            int fromAccount = rand.nextInt(COUNT_OF_ACCOUNTS);
            int toAccount = rand.nextInt(COUNT_OF_ACCOUNTS);
            double amount = rand.nextInt(MAX_SUM_OF_TRANSACTION);
            if (fromAccount != toAccount) {
                service.execute(() -> {
                    boolean result = bank.transfer(fromAccount, toAccount, amount);
                    if (result) {
                        System.out.printf("Перевод %.0f c аккаунта %s на аккаунт %s прошел успешно \n", amount, fromAccount, toAccount);
                    } else System.out.printf("Перевод %.0f c аккаунта %s на аккаунт %s отменен \n", amount, fromAccount, toAccount);
                });
            }
        }

        service.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.println(bank.getTotalBalance());

    }

}