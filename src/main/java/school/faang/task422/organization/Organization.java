package school.faang.task422.organization;

import school.faang.task422.donation.Donation;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Organization {
    private AtomicReference<BigDecimal> balance = new AtomicReference<>(BigDecimal.ZERO);

    public void addDonation(Donation donation) {
        BigDecimal currentBalance;
        BigDecimal newBalance;
        do {
            currentBalance = balance.get();
            newBalance = currentBalance.add(donation.getAmount());
        } while (!balance.compareAndSet(currentBalance, newBalance));
    }

    public double getBalance() {
        return balance.get().doubleValue();
    }
}
