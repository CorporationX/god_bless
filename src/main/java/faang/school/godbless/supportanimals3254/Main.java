package faang.school.godbless.supportanimals3254;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final List<Donation> DONATIONS = new ArrayList<>();
    static final Random RANDOM = new Random();
    static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    static final Organization DAI_LAPU = new Organization();

    public static void main(String[] args) {
        CompletableFuture<Void> futureDonationsCreated = CompletableFuture.runAsync(Main::fillDonationList, EXECUTOR);
        futureDonationsCreated.thenRun(() ->
                        DONATIONS.forEach(donation -> EXECUTOR.execute(() -> {
                            DAI_LAPU.addDonation(donation);
                            System.out.printf("%d was donated to Dai Lapu.%n", donation.getAmount());
                        })))
                .join();
        shutDownAndWait();
        System.out.printf("%d in total is donated to Dai Lapu", DAI_LAPU.getBalance());
    }

    private static synchronized void fillDonationList() {
        for (int i = 0; i < 100; i++) {
            DONATIONS.add(new Donation(RANDOM.nextInt(100, 50_000)));
        }
    }

    private static void shutDownAndWait() {
        EXECUTOR.shutdown();
        try {
            EXECUTOR.awaitTermination(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
