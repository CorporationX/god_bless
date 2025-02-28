package school.faang.sprint4.task_63222;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Organization {
    private static final String ADD_DONATION_FORM = "add donation";
    private final ReentrantLock lock = new ReentrantLock();
    @Getter
    private double amount;

    public void addDonation(Donation donation) {
        log.debug("Try to {} {}", ADD_DONATION_FORM, donation);
        lock.lock();
        try {
            log.debug("{} {}", ADD_DONATION_FORM, donation);
            amount += donation.getAmount();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            log.error("The thread was interrupted {} with an exception", Thread.currentThread(), e);
        } finally {
            lock.unlock();
        }
    }
}
