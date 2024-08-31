package faang.school.godbless.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class Organization {
    private AtomicInteger balance;

    public Organization(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.sum());
    }
}
