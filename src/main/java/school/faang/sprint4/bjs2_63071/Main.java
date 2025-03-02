package school.faang.sprint4.bjs2_63071;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int DONATIONS_PER_THREAD = 1000;
    private static final int UNIQUE_DONATION_IDS = 100;
    private static final int AWAIT_TERMINATIONS_MIN = 1;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < DONATIONS_PER_THREAD; j++) {
                    int id = j % UNIQUE_DONATION_IDS;
                    Donation donation = new Donation(id, BigDecimal.valueOf(1.0));
                    organization.addDonation(donation);
                }
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATIONS_MIN, TimeUnit.MINUTES)) {
                log.warn("Пул потоков не завершился в течение отведенного времени. Принудительное завершение");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван во время ожидания завершения пула потоков.", e);
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }

        System.out.println("Итоговый баланс: " + organization.getBalance());
    }
}
