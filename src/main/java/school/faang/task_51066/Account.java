package school.faang.task_51066;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class Account {
    @Getter
    private final UUID id;
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void deposit(double amount) {
        balance.updateAndGet(currentBalance -> currentBalance + amount);
    }

    public void withdraw(double amount) {
        balance.updateAndGet(currentBalance -> currentBalance - amount);
    }

    public double getBalance() {
        return balance.get();
    }

    public void setBalance(double amount) {
        balance.set(amount);
    }
}
