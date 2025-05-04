package school.faang.animal_support;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

@Getter
@Slf4j
public class Organization {
    private double balance = 0;
    private static final Semaphore semaphore = new Semaphore(1);

    public void addDonation(Donation donation) {
        try {
            semaphore.acquire();
            balance += donation.getAmount();
            log.info("Donation {} with amount {} is successful added to balance!",
                    donation.getId(),
                    donation.getAmount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
