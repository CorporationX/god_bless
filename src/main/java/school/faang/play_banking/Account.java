package school.faang.play_banking;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
public class Account {
    private final int id;
    private final double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }
}
