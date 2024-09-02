package faang.school.godbless.BJS2_25290;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        LongStream.range(0, 10).forEach(id -> executorService.submit(() -> {
            long randomAmount = ThreadLocalRandom.current().nextLong(10, 100);
            Donation donation = new Donation(id, randomAmount);
            organization.addDonation(donation);
        }));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Баланс организации: " + organization.getBalance());
    }
}
