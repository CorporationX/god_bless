package school.faang.task_51076;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
@ToString
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(double amount) {
        lock.lock();

        try {
            balance += amount;
            System.out.println("deposit of amount: " + amount + " successful, new balance: " + balance
                    + " of account with id: " + id);

        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();

        try {
            if (balance < amount) {
                System.out.println("withdraw rejected, balance: " + balance + " is not enough to withdraw: " + amount
                        + " from account with id: " + id);
                return false;
            }

            balance -= amount;
            System.out.println("withdraw of amount: " + amount + " successful, new balance: " + balance
                    + " of account with id: " + id);
            return true;

        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();

        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
