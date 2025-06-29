package school.faang.animal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DonationTesting {
    private static int THREAD_COUNT = 5;
    private static int ITERATION_COUNT = 50;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Organization organization = new Organization();

        for (int i = 0; i < ITERATION_COUNT; i++) {
            int finalI = i;
            double amount = 10000;
            executor.submit(() -> {
                organization.addDonation(new Donation(finalI, amount));
                log.info("Пожертвование {} в сумме {} поступило на счет.", finalI, amount);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.error("Задачи не были завершены вовремя. Принудительное завершение.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }

        log.info("Общий баланс организации {}", organization.getBalance());
    }
}
