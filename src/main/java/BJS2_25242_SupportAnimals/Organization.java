package BJS2_25242_SupportAnimals;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Slf4j
public class Organization {
    private final AtomicInteger balance = new AtomicInteger();

    public void addDonation(int donationSum) {
        balance.getAndAdd(donationSum);
    }
}
