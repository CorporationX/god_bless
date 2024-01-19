package faang.school.godbless.lets_play_bank;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void transfer(Account from, Account to, long money) {
        if (from.getBalance() >= money) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(Math.round(Math.random() * 7000));
                    from.withdraw(money);
                    to.deposit(money);
                    System.out.println("Transfer success");
                } catch (InterruptedException e) {
                    System.err.println("Transfer failed");
                }
            });
            future.join();
        } else {
            System.out.println("На счету аккаунта " + from.getId() + " недостаточно средств");
        }
    }

    public void getTotalBalance(Map<Integer, Account> accounts) {
        long totalBalance = accounts.values().stream().mapToLong(Account::getBalance).sum();
        System.out.println("Total balance of the bank: " + totalBalance);
    }
}
