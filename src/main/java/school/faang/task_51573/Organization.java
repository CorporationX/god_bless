package school.faang.task_51573;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

@Getter
public class Organization {
    private final AtomicReference<Double> totalDonationAmount = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        totalDonationAmount.updateAndGet(currentAmount ->
                currentAmount + donation.getAmount());
    }
}
