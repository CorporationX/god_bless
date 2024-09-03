package faang.school.godbless.BJS2_25284;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_COUNT = 10;
    private static final int DONATION_AMOUNT = 500;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Organization saveTheAnimals = new Organization();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            executorService.execute(() -> saveTheAnimals.addDonation(new Donation(finalI, DONATION_AMOUNT)));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Donation balance - " + saveTheAnimals.getDonationAmount());
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
