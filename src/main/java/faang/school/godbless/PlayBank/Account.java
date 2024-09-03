package faang.school.godbless.PlayBank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
    private int id;
    private int balance;
    private final Object lock = new Object();

    public void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    public boolean withdraw(int amount) {
        synchronized (lock) {
            if (balance - amount < 0) {
                System.out.println("денег нет");
                return false;
            }
            balance -= amount;
            return true;
        }
    }
}
