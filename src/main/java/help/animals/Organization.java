package help.animals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Getter
public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        if (Objects.isNull(donation)) {
            log.error("Your donation can t be null");
            throw new IllegalArgumentException();
        }
        balance.updateAndGet(currentBalance -> currentBalance + donation.getAmount());
        log.info("Donation {} with amount {} is successful added to balance!",
                donation.getId(),
                donation.getAmount());
    }
}
