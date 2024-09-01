package faang.school.godbless.BJS2_25234;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private String name;
    private AtomicInteger balance = new AtomicInteger(0);

    public Organization(String name) {
        this.name = name;
    }

    public int addDonation(Donation donation) {
        return balance.addAndGet(donation.getAmount());
    }
}
