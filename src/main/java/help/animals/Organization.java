package help.animals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Semaphore;

@Slf4j
@Getter
public class Organization {
    private double balance = 0;
    private static final int MAX_DONATIONS = 1;
    private static Semaphore semaphore = new Semaphore(MAX_DONATIONS);

    public void addDonation(Donation donation) {
        if (Objects.isNull(donation)) {
            log.error("Your donation can t be null");
            throw new IllegalArgumentException();
        }
        try {
            semaphore.acquire();
            balance += donation.getAmount();
            log.info("Donation {} with amount {} is successful added to balance!",
                    donation.getId(),
                    donation.getAmount());
        } catch (InterruptedException e) {
            log.error("Thread is interrupted!");
            Thread.currentThread().interrupt();
            throw new IllegalArgumentException(e.getCause().getMessage());
        } finally {
            semaphore.release();
        }
    }
}
