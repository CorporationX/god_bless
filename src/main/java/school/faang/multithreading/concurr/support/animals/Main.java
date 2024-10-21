package school.faang.multithreading.concurr.support.animals;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        IntStream.rangeClosed(1, 1000)
                .forEach(i -> {
                    executor.execute(() -> organization.addDonation(new Donation(i, i)));
                });

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            log.info("Общий баланс: {}", organization.getBalance());
        } else {
            log.error("Время истекло.");
        }
    }
}
