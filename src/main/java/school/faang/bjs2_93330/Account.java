package school.faang.bjs2_93330;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private int id;
    private double balance;
    private final Object lock = new Object();

    void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    void withdraw(double amount) {
        synchronized (lock) {
            balance -= amount;
        }
    }
}
