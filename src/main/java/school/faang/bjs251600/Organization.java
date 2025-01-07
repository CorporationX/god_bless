package school.faang.bjs251600;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Organization {

    private final List<Donation> donations = new CopyOnWriteArrayList<>();
    private final Lock lock = new ReentrantLock();

    public Donation addDonation(Donation donationt) {
        lock.lock();
        try {
            log.info("Donation {} has added", donationt.amount());
            donations.add(donationt);
            return donationt;
        } finally {
            lock.unlock();
        }
    }

    public double printBalace() {
        double sum;
        lock.lock();
        try {
            sum = donations.stream().mapToDouble(Donation::amount).sum();
        } finally {
            lock.unlock();
        }
        log.info("Sum of balance is {}", sum);
        return sum;
    }
}