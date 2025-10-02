package school.faang.support.animals;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Organization {
    private final AtomicReference<BigDecimal> balance = new AtomicReference<>(BigDecimal.ZERO);

    public void addDonation(Donation donation) {
        balance.updateAndGet(current -> current.add(donation.getAmount()));
        log.info("Поступил новый платёж в размере: {}", donation.getAmount());
    }

    public BigDecimal getBalance() {
        return balance.get();
    }
}
