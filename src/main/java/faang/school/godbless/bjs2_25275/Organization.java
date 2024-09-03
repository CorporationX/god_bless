package faang.school.godbless.bjs2_25275;

import com.google.common.util.concurrent.AtomicDouble;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Organization {
    private static final double INITIAL_AMOUNT = 0D;

    private AtomicDouble balance = new AtomicDouble(INITIAL_AMOUNT);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
        log.info("Donut {} was added", donation.getAmount());
    }

    public double getBalance() {
        return balance.get();
    }
}
