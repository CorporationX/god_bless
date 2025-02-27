package school.faang.playingbank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@EqualsAndHashCode
public class Account {
    private static int currentId = 1;

    private final int id = currentId++;
    private final Object lock = new Object();

    private int balance = 0;

    public void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
            log.info("{} balance was replenished by {} money", getId(), amount);
        }
    }

    public void withdraw(int amount) {
        synchronized (lock) {
            balance -= amount;
            log.info("{} money were debited from the account {}", amount, getId());
        }
    }

    public void replenishAccountBalance(int amount) {
        balance += amount;
        log.info("{} account was replenished by {} money", getId(), amount);
    }
}
