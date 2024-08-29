package animals.care;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Donation {
    private static final AtomicInteger ID_COUNT = new AtomicInteger(0);
    private final int id;
    private final int donationAmount;

    public Donation(int donationAmount) {
        id = ID_COUNT.getAndIncrement();
        this.donationAmount = donationAmount;
    }
}
