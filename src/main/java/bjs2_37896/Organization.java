package bjs2_37896;

import lombok.Getter;

import java.util.concurrent.atomic.DoubleAdder;

@Getter
public class Organization {
    private final DoubleAdder balance = new DoubleAdder();

    public void addDonation(Donation donation) {
        balance.add(donation.getAmount());
    }
}
