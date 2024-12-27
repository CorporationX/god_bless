package school.faang.sprint4.task_51572;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class Organization {
    private final AtomicLong balance = new AtomicLong(0);

    public void addDonation(@NonNull Donation donation) {
        long currentBalance = balance.addAndGet(donation.getAmount());
        log.info("Donated {}. Donation id = {}. Current balance: {}",
                donation.getAmount(),
                donation.getId(),
                currentBalance);
    }

    public void printBalance() {
        log.info("Current balance of organization is: {}", balance.get());
    }
}
