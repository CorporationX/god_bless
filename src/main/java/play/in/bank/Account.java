package play.in.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Account {
    private final int id;
    private volatile long balance;
    private final Object lock = new Object();

    public void deposit(int amount) {
        synchronized (lock) {
            this.balance += amount;
        }
    }

    public void withdraw (int amount) {
        synchronized (lock) {
            this.balance -= amount;
        }
    }
}
