package faang.school.godbless.play_bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@ToString
@AllArgsConstructor
public class Account {
    private int id;
    private volatile int balance;
    private final Lock lock = new ReentrantLock();

    public void deposit(int moneyToAdd) {
        balance += moneyToAdd;
    }

    public void withdraw(int moneyToTake) {
        if (balance < moneyToTake) {
            throw new IllegalArgumentException("Account " + id + " does not have enough money");
        }
        balance -= moneyToTake;
    }
}

