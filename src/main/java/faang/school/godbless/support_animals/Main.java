package faang.school.godbless.support_animals;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Organization hogwarts = new Organization(new AtomicReference<>(new BigDecimal(0)));
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (double i = 0; i < 1000; i += 10.5) {
            double amount = i;
            futures.add(CompletableFuture.runAsync(() -> hogwarts.addDonation(new Donation(BigDecimal.valueOf(amount))), executorService));
        }

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();

        log.info("Result: {}", hogwarts.getBigDecimal());
    }
}