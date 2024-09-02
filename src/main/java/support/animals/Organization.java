package support.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
public class Organization {
    @Getter
    private final AtomicLong balance = new AtomicLong(0);

    public void addDonation(Donation donation) {
        this.balance.addAndGet(donation.getDonate());
        System.out.println("В баланс огранизации было добавлено: " + donation.getDonate());
    }
}
