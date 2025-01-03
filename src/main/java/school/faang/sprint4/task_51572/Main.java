package school.faang.sprint4.task_51572;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static final int THREAD_POOL_SIZE = 100;
    public static final int DONATION_AMOUNT = 5000;
    public static final int DONATION_UPPER_BOUND = 1000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Random random = new Random();
        Organization organization = new Organization();

        IntStream.range(0, DONATION_AMOUNT)
                .forEach((i) -> {
                    executorService.submit(() -> {
                        long amount = random.nextInt(DONATION_UPPER_BOUND);
                        organization.addDonation(new Donation(i, amount));
                    });
                });

        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        organization.printBalance();
    }
}
