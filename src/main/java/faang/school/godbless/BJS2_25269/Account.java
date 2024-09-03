package faang.school.godbless.BJS2_25269;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Account {
    @EqualsAndHashCode.Include
    private final long id;
    private int balance;
    @ToString.Exclude
    private final Object lock = new Object();

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        this.balance -= money;
    }
}
