package faang.school.godbless.lets_play_bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
public class Account {
    @Getter
    private int id;
    private volatile long balance;
    private final ReentrantLock lock = new ReentrantLock(true);

    public void deposit(long money) {
        lock.lock();
        try {
            System.out.println("Выполнено пополнение счета аккаунта " + id + " на сумму " + money);
            balance += money;
            System.out.println("Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(long money) {
        lock.lock();
        try {
            System.out.println("Выполнено списание со счета аккаунта " + id + " на сумму " + money);
            balance -= money;
            System.out.println("Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
