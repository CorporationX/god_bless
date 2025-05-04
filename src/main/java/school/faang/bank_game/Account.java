package school.faang.bank_game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Account {
    private int id;
    private double balance;
    private final Object lock = new Object();

    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
            log.info("Bank {} balance increased on {}", id, amount);
        }
    }

    public void withdraw(double amount)  {
        synchronized (lock) {
            if (balance < amount) {
                log.error("Bank {} balance is insufficient on {}", id, amount);
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException("Insufficient balance");
            }
            balance -= amount;
            log.info("Bank {} balance decreased on {}", id, amount);
        }
    }
}