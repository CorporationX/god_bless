package school.faang.task_63094;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int FACTOR = 100;
    private static final int NUMBER_OF_DONATIONS = 10;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < NUMBER_OF_DONATIONS; i++) {
            final int donationId = i;
            service.submit(() -> {
                Donation donation = new Donation(donationId, Math.random() * FACTOR);
                organization.addDonation(donation);
            });
        }
        service.shutdown();
        try {

            if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
                service.shutdownNow();
                System.out.println("Задачи не завершились в течение 5 секунд, принудительное завершение.");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }


        log.info("Итоговый баланс организации: " + organization.getTotalBalance());

    }
}
