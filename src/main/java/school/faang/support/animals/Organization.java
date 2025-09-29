package school.faang.support.animals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Organization {
    private static final AtomicInteger balanceOrganization = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balanceOrganization.addAndGet(donation.getAmount());
        log.info("Поступил новый платёж в размере: {}", donation.getAmount());
    }

    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        int threadsCount = 5;
        int donationsPerThread = 3;
        AtomicInteger id = new AtomicInteger(0);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < donationsPerThread; j++) {
                    int amount = (int) (Math.random() * 100 + 1);
                    Donation donation = new Donation(id.incrementAndGet(), amount);
                    organization.addDonation(donation);

                    try {
                        Thread.sleep(100);
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

        log.info("Финальный баланс: {}", balanceOrganization.get());
    }
}
