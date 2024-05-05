package faang.school.godbless.BJS2_6221;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Organization {
    private String name;
    private AtomicInteger generalBalance = new AtomicInteger();

    public Organization(String name) {
        this.name = name;
    }

    public void addBalance(Donation donation) {
        if (donation != null) {
            generalBalance.addAndGet(donation.getDonation());
        }
    }
}
