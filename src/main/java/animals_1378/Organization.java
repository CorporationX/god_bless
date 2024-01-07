package animals_1378;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Organization {
    private AtomicInteger balance;

    public int addDonation(Donation donation) {
        System.out.println("Добавляем донат - " + donation.getDonat());
        return balance.addAndGet(donation.getDonat());
    }
}