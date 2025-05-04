package school.faang.animal_support;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@Slf4j
public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        try {
            balance.updateAndGet(currentBalance -> currentBalance + donation.getAmount());
            log.info("Donation {} with amount {} is successful added to balance!",
                    donation.getId(),
                    donation.getAmount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
