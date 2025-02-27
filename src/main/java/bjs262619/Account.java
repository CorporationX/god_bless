package bjs262619;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class Account {
    private final int id;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public void deposit(double amount) {
        try {
            lock.lock();
            this.setBalance(this.getBalance() + amount);
            log.info("Funds {} have been transferred to the account {}", amount, this);
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        try {
            lock.lock();
            if (this.getBalance() < amount) {
                log.info("Insufficient funds to transfer from the account {}", this);
                Thread.currentThread().interrupt();
                throw new RuntimeException();
            }
            this.setBalance(this.getBalance() - amount);
            log.info("Funds {} have been transferred from the account {}", amount, this);
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }
}
