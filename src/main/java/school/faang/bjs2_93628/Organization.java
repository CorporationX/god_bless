package school.faang.bjs2_93628;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Organization {
    private final AtomicInteger balance = new AtomicInteger(0);
    private final List<Donation> historyDonation = new CopyOnWriteArrayList<>();

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
        log.info("Пришел донат - {}, баланс составляет {}", donation, balance.get());
        historyDonation.add(donation);
    }

    public void printBalance() {
        log.info("Баланс составляет {}", balance.get());
    }

    public void printHistoryDonat() {
        log.info("История донатов: ");
        historyDonation.stream().forEach(donation -> System.out.println(donation));

    }
}
