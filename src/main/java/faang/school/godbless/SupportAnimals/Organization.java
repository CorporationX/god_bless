package faang.school.godbless.SupportAnimals;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
@Data
public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
    }
}
