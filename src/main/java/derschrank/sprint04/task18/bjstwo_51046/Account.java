package derschrank.sprint04.task18.bjstwo_51046;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public record Account(
        int id,
        DoubleAdder balance,
        Lock lock
) {
    public Account(int id) {
        this(id, new DoubleAdder(), new ReentrantLock());
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance.add(amount);
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (amount < balance.doubleValue()) {
                balance.add((-1 * amount));
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
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
}
