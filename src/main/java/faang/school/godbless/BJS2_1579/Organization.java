package faang.school.godbless.BJS2_1579;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.atomic.DoubleAdder;

@Getter
@EqualsAndHashCode
public class Organization {
    private final DoubleAdder balance = new DoubleAdder();

    public void addDonation(Donation donation) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance.add(donation.getAmount());
    }

    public double getTotalBalance() {
        return balance.sum();
    }

    public double getBalance() {
        return balance.sum();
    }
}