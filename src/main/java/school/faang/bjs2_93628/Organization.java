package school.faang.bjs2_93628;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class Organization {
    private BigDecimal balance = new BigDecimal(0);
    private final List<Donation> historyDonation = new CopyOnWriteArrayList<>();

    public void addDonation(Donation donation) {
        balance = balance.add(BigDecimal.valueOf(donation.getAmount()));
        log.info("Пришел донат - {}, баланс составляет {}", donation, balance);
        historyDonation.add(donation);
    }

    public void printBalance() {
        log.info("Баланс составляет {}", balance);
    }

    public void printHistoryDonat() {
        log.info("История донатов: ");
        historyDonation.forEach(System.out::println);

    }
}
