package faang.school.godbless.letssupporttheanimals;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int donationAmount = (i + 1) * 100;
            executorService.submit(() -> {
                Donation donation = new Donation(donationAmount);
                organization.addDonation(donation);
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
        System.out.printf("Final total balance: %s", organization.getTotalBalance());
    }
}