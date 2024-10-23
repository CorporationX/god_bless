package school.faang.animals;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

@Data
public class Organization {
    AtomicReference<Double> balance = new AtomicReference<>((double) 0);

    public void addDonation(double donation) {
        balance.accumulateAndGet(donation, Double::sum);
    }
}
