package school.faang.sprint4.task_63222;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Organization {
    private static final Set<Donation> UNPROCESSED_TRANSACTIONS = new HashSet<>();
    private static final String ADD_DONATION_FORM = "add donation";
    private final ReentrantLock lock = new ReentrantLock();
    @Getter
    private double amount;

    public void addDonation(Donation donation) {
        log.debug("Try to {} {}, now {}", ADD_DONATION_FORM, donation, amount);
        lock.lock();
        try {
            log.debug("{} {} now {}", ADD_DONATION_FORM, donation, amount);
            amount += donation.getAmount().doubleValue();
        } catch (Exception e) {
            UNPROCESSED_TRANSACTIONS.add(donation);
            Thread.currentThread().interrupt();
            log.error("The thread was interrupted {} with an exception", Thread.currentThread(), e);
        } finally {
            lock.unlock();
        }
    }
}
