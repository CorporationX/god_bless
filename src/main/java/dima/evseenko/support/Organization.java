package dima.evseenko.support;

import lombok.Getter;

import java.util.concurrent.atomic.DoubleAdder;

@Getter
public class Organization {
    private final DoubleAdder totalAmount = new DoubleAdder();

    public void addDonation(Donation donation) {
        totalAmount.add(donation.getAmount());
    }
}
