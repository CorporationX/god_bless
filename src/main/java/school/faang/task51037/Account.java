package school.faang.task51037;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RequiredArgsConstructor
@ToString
@Getter
public class Account {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    private void validateAmount(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("amount не может быть меньше нуля");
        }
    }

    private void lockBalance(Runnable runnable) {
        lock.lock();

        try {
            runnable.run();
            if (balance <= 0) {
                log.error("{} не может быть меньше либо равен 0", balance);
                balance = 0;
            }
        } finally {
            lock.unlock();
        }
    }



    public void deposit(double amount) {
        validateAmount(amount);

        lockBalance(() -> balance += amount);
        log.info("Был выполнен депозит {}", balance);
    }

    public void withdraw(double amount) {
        validateAmount(amount);

        lockBalance(() -> balance -= amount);
    }
}
