package school.faang.bjs2_93325;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@AllArgsConstructor
@ToString(exclude = "lock")
public class Account {
    private final int id;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
