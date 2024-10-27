package school.faang.task422;

import school.faang.task422.donation.Donation;
import school.faang.task422.organization.Organization;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 10;
    private static final int ONE_MINUTES = 1;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(6);
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                Donation donation = new Donation(finalI, new BigDecimal(new Random().nextDouble(99)));
                organization.addDonation(donation);
            }, service));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println(organization.getBalance());

        service.shutdown();
        try {
            if (!service.awaitTermination(ONE_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Ошибка, деньги утеряны");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getStackTrace().toString());
        }
    }
}
