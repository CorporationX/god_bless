package faang.school.godbless.BJS2_25267;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private AtomicInteger balanceMoney = new AtomicInteger();

    public void addDonation(Donation donation) {
        balanceMoney.addAndGet(donation.getAmountMoney());
    }
}