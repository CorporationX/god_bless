package school.faang.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();
    private static final int TIME_SLEEP = 1000;

    public void deposit(double amount) {
        executeLocked(() -> {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance += amount;
        });
    }

    public boolean withdraw(double amount) {
        return executeLocked(() -> {
            if (balance >= amount) {
                Thread.sleep(TIME_SLEEP);
                balance -= amount;
                return true;
            } else {
                System.out.println("На счету не достаточно средств " + balance);
                return false;
            }
        });
    }

    public double getBalance() {
        return balance;
    }

    private <T> T executeLocked(Callable<T> action) {
        try {
            lock.lock();
            return action.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private void executeLocked(Runnable action) {
        try {
            lock.lock();
            action.run();
        } finally {
            lock.unlock();
        }
    }
}

