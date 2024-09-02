package faang.school.godbless.BJS2_25290;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Organization {
    private AtomicLong balance = new AtomicLong(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
        System.out.println("Добавлено пожертвование: " + donation);
    }
}
