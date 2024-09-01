package faang.school.godbless.BJS2_25256;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        IntStream.range(0, 8).forEach(i -> executor.execute(() -> organization
                .addDonation(new Donation(i, ThreadLocalRandom.current().nextInt(1000, 10000)))));
        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("Balance: " + organization.getBalance());
    }
}
