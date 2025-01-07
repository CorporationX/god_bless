package faang.school.godbless.FourthSprint.bjs2_52228;

import lombok.Getter;

import java.util.concurrent.atomic.DoubleAdder;


@Getter
public class Organization {
    private static final long SLEEP_TIME = 100;
    private DoubleAdder balance = new DoubleAdder();

    public void addDonation(Donation donation) {
        try {
            Thread.sleep(SLEEP_TIME);
            balance.add(donation.getAmount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
