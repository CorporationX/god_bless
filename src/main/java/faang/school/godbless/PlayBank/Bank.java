package faang.school.godbless.PlayBank;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
public class Bank {
    public ConcurrentHashMap<Integer, Account> accounts;

    public Bank(ConcurrentHashMap<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean transfer(int from, int to, int amount) {
        Account fromAccount = accounts.get(from);
        if (fromAccount.getBalance() < amount) {
            return false;
        }
        Account toAccount = accounts.get(to);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println(Thread.currentThread().getId() + " | Transferred " + amount + " from " + from + " to " + to);
        return true;
    }
}
