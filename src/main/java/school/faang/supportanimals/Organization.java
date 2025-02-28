package school.faang.supportanimals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;


@Slf4j
@Getter
public class Organization {

    private final AtomicReference<Double> balance;

    public Organization() {
        this.balance = new AtomicReference<>(0.0);
    }

    public void addDonation(double amount) {
        if (amount < 0) {
            log.warn("Сумма донаций не может быть отрицательной!");
            return;
        }
        Donation donation = new Donation(amount);
        log.info("Донация №{} на сумму {} совершена!", donation.getId(), donation.getAmount());
        balance.updateAndGet(current -> current + amount);
    }
}
