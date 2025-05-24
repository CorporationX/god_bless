package school.faang.bank;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 10;
    private static final int WAITING_TIME = 10;

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Random random = new Random();

        for (int i = 1; i <= 5; i++) {
            bank.addAccount(new Account(i, 1000.0));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                int fromId = random.nextInt(5) + 1;
                int toId = random.nextInt(5) + 1;
                double amount = random.nextInt(200) + 1;

                boolean success = bank.transfer(fromId, toId, amount);
                if (success) {
                    log.info("Transfer of {} from account  {} to account  {} was successful \n", amount, fromId, toId);
                } else {
                    System.out.printf("Ошибка перевода %.2f со счёта #%d на счёт #%d " +
                            "(недостаточно средств или одинаковые счета)%n", amount, fromId, toId);
                    log.info("Transfer error: {} from account #{} to account #{} " +
                            "insufficient funds or identical accounts", amount, fromId, toId);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(WAITING_TIME, TimeUnit.SECONDS);


        log.info("Total balance {} ", bank.getTotalBalance());
    }
}
