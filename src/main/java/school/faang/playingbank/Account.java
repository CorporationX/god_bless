package school.faang.playingbank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Getter
@EqualsAndHashCode
public class Account {
    private final UUID id = UUID.randomUUID();
    private final String name;
    private final Object lock = new Object();

    private int balance = 0;

    public Account(String name) {
        this.name = name;
    }

    public void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
            log.info("{} balance was replenished by {} money", getName(), amount);
        }
    }

    public void withdraw(int amount) {
        synchronized (lock) {
            balance -= amount;
            log.info("{} money were debited from the account {}", amount, getName());
        }
    }

    public void replenishAccountBalance(int amount) {
        synchronized (lock) {
            balance += amount;
            log.info("{} account was replenished by {} money", getName(), amount);
        }
    }
}
