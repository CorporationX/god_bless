package faang.school.godbless.support_animals;

import lombok.Data;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class Organization {
    private AtomicReference<BigDecimal> bigDecimal;

    public Organization(AtomicReference<BigDecimal> bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public void addDonation(Donation donation) {
        bigDecimal.accumulateAndGet(donation.getAmount(), BigDecimal::add);
    }
}