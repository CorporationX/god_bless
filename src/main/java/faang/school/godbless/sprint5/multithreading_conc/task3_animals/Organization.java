package faang.school.godbless.sprint5.multithreading_conc.task3_animals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
@Getter
public class Organization {

    private final AtomicInteger balance;

    public Organization() {
        this.balance = new AtomicInteger();
    }

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
    }
}
