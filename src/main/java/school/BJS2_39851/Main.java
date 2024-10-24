package school.BJS2_39851;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int SIZE_OF_THREADS = 30;
    private static final int MAX_SUM_OF_TRANSACTION = 1000;

    public static void main(String[] args){

        Bank bank = new Bank();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            bank.addAccounts(i, new Account(i, rand.nextInt(MAX_SUM_OF_TRANSACTION)));
        }
        ExecutorService service = Executors.newFixedThreadPool(SIZE_OF_THREADS);

        for (int i = 0 ; i < SIZE_OF_THREADS; i++) {
            int fromAccount = rand.nextInt(SIZE_OF_THREADS);
            int toAccount = rand.nextInt(SIZE_OF_THREADS);
            double amount = rand.nextInt(MAX_SUM_OF_TRANSACTION);
            if (fromAccount != toAccount) {
                service.execute(() -> bank.transfer(fromAccount, toAccount, amount));
            }
        }

        service.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println(bank.getTotalBalance());

    }
}