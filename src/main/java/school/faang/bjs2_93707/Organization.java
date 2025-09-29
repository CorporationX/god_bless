package school.faang.bjs2_93707;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Setter
@Getter
public class Organization {
    private static final int SLEEPING_TIME = 5;
    private AtomicReference<Double> balance = new AtomicReference<>(0.00);

    public void addDonation(@NonNull Donation donation) {
        try {
            log.info("Начинаем зачислять {} руб по платежу номер {}.", donation.getAmount(), donation.getId());
            balance.accumulateAndGet(donation.getAmount(), Double::sum);
            TimeUnit.SECONDS.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Перевод номер {} на сумму {} отменен.", donation.getId(), donation.getAmount());
        }
    }
}
