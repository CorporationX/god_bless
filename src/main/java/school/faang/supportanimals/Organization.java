package school.faang.supportanimals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;


@Slf4j
@Getter
public class Organization {

    private final AtomicReference<BigDecimal> balance;

    public Organization() {
        this.balance = new AtomicReference<>(BigDecimal.ZERO);
    }

    public void addDonation(double amount) {
        if (amount < 0) {
            log.warn("Сумма донаций не может быть отрицательной!");
            return;
        }
        BigDecimal donationAmount = BigDecimal.valueOf(amount);
        Donation donation = new Donation(donationAmount);
        log.info("Донация №{} на сумму {} совершена!", donation.getId(), donation.getAmount());
        balance.updateAndGet(current -> current.add(donationAmount));
    }
}
