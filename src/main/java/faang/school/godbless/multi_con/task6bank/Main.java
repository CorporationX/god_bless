package faang.school.godbless.multi_con.task6bank;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Random random = new Random();
        ExecutorService executor = Executors.newCachedThreadPool();

        bank.addAccount(1, 1000);
        bank.addAccount(2, 2000);
        bank.addAccount(3, 3000);

        for (int i = 0; i < 15; i++) {
            int fromId = random.nextInt(3) + 1;
            int toId;
            do {
                toId = random.nextInt(3) + 1;
            } while (fromId == toId);

            double amount = random.nextDouble() * 1000;

            int finalToId = toId;
            executor.submit(() -> bank.transfer(fromId, finalToId, amount));
        }

        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Банк сломался");
        }

        System.out.println("Общий баланс после переводов: " + Math.round(bank.getTotalBalance() * 1_000_000_000) / 1_000_000_000);
    }
}
