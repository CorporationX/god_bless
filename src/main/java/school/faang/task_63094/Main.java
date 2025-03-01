package school.faang.task_63094;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final  int FACTOR = 100;

    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int donationId = i;
            service.submit(() -> {
                Donation donation = new Donation(donationId, Math.random() * FACTOR);
                organization.addDonation(donation);
            });
        }
        service.shutdown();
        while (!service.isTerminated()) {
        }

        log.info("Итоговый баланс организации: " + organization.getTotalBalance());

    }
}
