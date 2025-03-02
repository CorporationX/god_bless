package school.faang.task_63094;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Organization {
    @Getter
    private final AtomicReference<Double> totalBalance = new AtomicReference<>(0.0);
    private final Set<Integer> donationRegistr = Collections.synchronizedSet(new HashSet<>());

    public void addDonation(Donation donation) {
        if (!donationRegistr.contains(donation.id())) {
            totalBalance.updateAndGet(totalBalance -> totalBalance + donation.amount());
            donationRegistr.add(donation.id());
            log.info("пожертвование принято");
        } else {
            log.info("запись одного и того же пожертвования запрещена");
        }
    }
}
