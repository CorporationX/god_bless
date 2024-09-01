package faang.school.godbless.BJS2_25303;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Account {
    private int id, balance;

    public void deposit(long amount) {
        System.out.println("Account id: " + id + " balance: " + balance);
        balance += amount;
        System.out.println("Account id: " + id + " balance after deposit + " + amount + " is " + balance);

    }

    public void withdraw(long amount) {
        System.out.println("Account id: " + id + " balance: " + balance);
        balance -= amount;
        System.out.println("Account id: " + id + " balance after withdraw - " + amount + " is " + balance);
    }
}
