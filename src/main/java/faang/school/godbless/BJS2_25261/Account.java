package faang.school.godbless.BJS2_25261;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Account {
    private int id;
    private int balance;

    @ToString.Exclude
    private final Object lock = new Object();

    public Account(int id) {
        this.id = id;
        balance = ThreadLocalRandom.current().nextInt(0, 500);
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdrow(int amount){
        balance -= amount;
    }


}
