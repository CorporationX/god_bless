package play_in_bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Account {
    private int id;
    private double balance;
    private final Object lock = new Object();

    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
            log.info("Bank {} balance was supplied with {}$", id, amount);
        }
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        synchronized (lock) {
            if (amount > balance) {
                log.error("Account balance is less then amount!");
                throw new IllegalArgumentException("Balance is less then amount");
            }
            balance -= amount;
            log.info("Bank {} balance was reduced with {}$", id, amount);
        }
    }
}
