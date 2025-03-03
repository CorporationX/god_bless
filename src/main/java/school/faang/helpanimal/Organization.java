package school.faang.helpanimal;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Slf4j
public class Organization {
    private final AtomicReference<BigDecimal> totalSum = new AtomicReference<>(BigDecimal.ZERO);

    public void addDonation(Donation donation) {
        totalSum.updateAndGet(sum -> sum.add(donation.amount()));
        log.info("(id : {}) New donation on sum: {}", donation.id(), donation.amount());
    }
}
