package school.faang.support.animals;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int COUNT_THREADS = 5;
    private static final int COUNT_DONATIONS_IN_THREAD = 3;
    private static final int TIME_FOR_WAITING = 100;

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        AtomicInteger id = new AtomicInteger(0);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < COUNT_THREADS; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < COUNT_DONATIONS_IN_THREAD; j++) {
                    BigDecimal amount = BigDecimal.valueOf(Math.random() * 100 + 1)
                            .setScale(2, RoundingMode.HALF_UP);
                    Donation donation = new Donation(id.incrementAndGet(), amount);
                    organization.addDonation(donation);

                    try {
                        Thread.sleep(TIME_FOR_WAITING);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        log.info("Финальный баланс: {}", organization.getBalance());
    }
}
