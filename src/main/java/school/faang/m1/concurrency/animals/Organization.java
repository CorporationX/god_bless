package school.faang.m1.concurrency.animals;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAdder;

public class Organization implements AutoCloseable {

    private final DoubleAdder balance = new DoubleAdder();
    private final ConcurrentHashMap<Integer, Boolean> seen = new ConcurrentHashMap<>();

    private final ExecutorService exec;

    public Organization(ExecutorService exec) {
        this.exec = exec;
    }

    public void addDonation(Donation donation) {
        Boolean prev = seen.putIfAbsent(donation.id(), Boolean.TRUE);
        if (prev == null) {
            balance.add(donation.amount());
        }
    }

    public double getBalance() {
        return balance.sum();
    }

    @Override
    public void close() {
        exec.shutdown();
        try {
            if (!exec.awaitTermination(10, TimeUnit.SECONDS)) {
                exec.shutdownNow();
            }
        } catch (InterruptedException ie) {
            exec.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public Executor executor() {
        return exec;
    }
}
