package school.faang.animals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Getter
public class Organization {
    private final AtomicReference<Double> donations = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        donations.getAndUpdate(value -> value + donation.getAmount());
    }
}
