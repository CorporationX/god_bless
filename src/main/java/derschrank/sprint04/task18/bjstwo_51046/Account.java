package derschrank.sprint04.task18.bjstwo_51046;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public record Account(
        int id,
        DoubleAdder balance,
        Lock lock
) {
    private static final int AWAIT_FOR_TRY_LOCK_MILLIS = 100;

    public Account(int id) {
        this(id, new DoubleAdder(), new ReentrantLock());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance.add(amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount < balance.doubleValue()) {
                balance.add((-1 * amount));
                return true;
            }
        }
        return false;
    }

    public double getBalance() {
        while (!lock.tryLock()) {
            delayToTry(AWAIT_FOR_TRY_LOCK_MILLIS);
        }
        try {
            return balance.doubleValue();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return String.format("[# %4d] %7.2f$", id, balance.doubleValue());
    }

    private void delayToTry(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("Deposit was interrupted: " + e);
            Thread.currentThread().interrupt();
        }
    }
}
