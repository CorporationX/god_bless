package school.faang.sprint_4.task_51567;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final List<Donation> donations = new CopyOnWriteArrayList<>();

    public void addDonation(double donation) {
        donations.add(new Donation(counter.incrementAndGet(), donation));
    }

    public List<Donation> getDonations() {
        return List.copyOf(donations);
    }

    public BigDecimal getTotalBalance() {
        return donations.stream()
                .map(donation -> BigDecimal.valueOf(donation.amount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
