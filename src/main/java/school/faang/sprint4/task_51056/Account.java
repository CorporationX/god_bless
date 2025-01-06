package school.faang.sprint4.task_51056;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Account {
    private final int id;
    private double balance;

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount < balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public synchronized double getBalance() {
        return balance;
    }
}
