package school.faang.task51570;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class Organization {
    private final List<Donation> donations = new CopyOnWriteArrayList<>();

    public Donation addDonation(Donation donation) {
        donations.add(donation);
        log.info("Добавлено пожертвование: {}", donation);

        return donation;
    }

    public double getTotalAmount() {
        double totalAmount = donations.stream().map(Donation::amount)
                .reduce(0.0, Double::sum);

        log.info("Итоговый баланс организации: {}", totalAmount);
        return totalAmount;
    }
}
