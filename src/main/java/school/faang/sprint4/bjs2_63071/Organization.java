package school.faang.sprint4.bjs2_63071;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Organization {
    private final Set<Integer> donationIds = ConcurrentHashMap.newKeySet();
    private final AtomicReference<BigDecimal> balance = new AtomicReference<>(BigDecimal.ZERO);

    public void addDonation(@NonNull Donation donation) {
        int id = donation.getId();
        if (donationIds.add(id)) {
            BigDecimal amount = donation.getAmount();
            while (true) {
                BigDecimal current = balance.get();
                BigDecimal next = current.add(amount);
                if (balance.compareAndSet(current, next)) {
                    log.info("Пожертвование успешно добавлено: ID={}, Сумма={}", id, amount);
                    break;
                }
            }
        } else {
            log.warn("Пожертвование отклонено: дубликат ID={}", id);
        }
    }

    public BigDecimal getBalance() {
        return balance.get();
    }
}
