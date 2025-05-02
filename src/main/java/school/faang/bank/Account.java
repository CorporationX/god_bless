package school.faang.bank;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Data
public class Account {
    private final int id;
    private volatile double balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        log.debug("Thread: {}, executing getBalance()", Thread.currentThread().getName());
        //Тут мне кажется синхронизация не нужна, достаточно volatile, но зависит от требований я бы сказал.
        //Если начать трансфер (например, нажать кнопку в приложении) и параллельно другому потоку вычитать старое
        // (еще физически не измененное) значение это ок, то тогда можно так
        return balance;
    }
}
