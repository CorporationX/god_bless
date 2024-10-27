package school.faang.m1s4.bjs2_40138_wwf;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class Organization {
    private static final int N_POOLS = 5;
    @Getter
    private final ExecutorService service = Executors.newFixedThreadPool(N_POOLS);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private double balance;
    private final List<Donation> donations = new ArrayList<>();

    public void addDonation(Donation donation) {
        CompletableFuture.runAsync(() -> {
            lock.writeLock().lock();
            try {
                balance += donation.getAmount();
                donations.add(donation);
                log.info(String.format("New donation: %.2f", donation.getAmount()));
            } finally {
                lock.writeLock().unlock();
            }
        }, service);
    }

    public double getBalance() {
        return CompletableFuture.supplyAsync(() -> {
            lock.readLock().lock();
            try {
                log.info(String.format("Current balance: %.2f", balance));
                return balance;
            } finally {
                lock.readLock().unlock();
            }
        }, service).join();
    }

    public List<Donation> getDonationsInfo() {
        return CompletableFuture.supplyAsync(() -> {
            lock.readLock().lock();
            try {
                return new ArrayList<>(donations);
            } finally {
                lock.readLock().unlock();
            }
        }, service).join();
    }
}
