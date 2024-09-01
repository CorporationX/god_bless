package faang.school.godbless.BJS2_25303;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Account {
    private int id, balance;

    public void deposit(int amount) {
        System.out.println("Account id: " + id + " balance: " + balance);
        balance += amount;
        System.out.println("Account id: " + id + " balance after deposit + " + amount + " is " + balance + " Thread: " + Thread.currentThread().getId());

    }

    public void withdraw(int amount) {
        System.out.println("Account id: " + id + " balance: " + balance);
        balance -= amount;
        System.out.println("Account id: " + id + " balance after withdraw - " + amount + " is " + balance);
    }
}
