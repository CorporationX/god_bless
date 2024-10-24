package school.faang.helpAnimals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

@Getter
public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        try {
            Thread.sleep(1000);
            balance.updateAndGet(value -> value + donation.getAmount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
