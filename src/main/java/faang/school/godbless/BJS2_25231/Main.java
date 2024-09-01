package faang.school.godbless.BJS2_25231;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAdder;

@Slf4j
public class Main {
    private static final int TRANSACTIONS_AMOUNT = 100;
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Organization saveDogs = new Organization(new DoubleAdder());
        for (int i = 0; i < TRANSACTIONS_AMOUNT; i++) {
            int finalI = i;
            executorService.execute(() -> saveDogs.addDonation(new Donation(finalI, ThreadLocalRandom.current().nextDouble(0, 1000))));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Thread error: {}", e.getMessage());
        }
        System.out.println(saveDogs.getCurrentBalance());
    }
}
