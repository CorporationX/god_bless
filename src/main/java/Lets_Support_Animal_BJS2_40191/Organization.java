package Lets_Support_Animal_BJS2_40191;

import lombok.Getter;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        balance.updateAndGet(currentBalance -> currentBalance + donation.getAmount());
    }

}