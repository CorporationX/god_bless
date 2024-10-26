package school.faang.helpAnimals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

@Getter
public class Organization {
    private static final int SLEEP_TIME = 1000;
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        try {
            Thread.sleep(SLEEP_TIME);
            balance.updateAndGet(value -> value + donation.getAmount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
