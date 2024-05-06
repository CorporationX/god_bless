package bank;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account {
    private final ReentrantLock lock = new ReentrantLock();
    private int id;
    private double balance;
    private static int counterId = 1;

    public Account(double balance) {
        this.id = counterId;
        this.balance = balance;
        counterId++;
    }

    public boolean deposit(double deposit) {
        lock.lock();
        if (deposit <= 0) {
            System.out.println("Deposit cant be less than zero");
            lock.unlock();
            return false;
        }
        this.setBalance(this.getBalance() + deposit);
        lock.unlock();
        return true;
    }

    public boolean withdraw(double withdraw) {
        lock.lock();
        if (withdraw <= 0) {
            System.out.println("Withdraw cant be more than zero");
            lock.unlock();
            return false;
        }
        if (!checkWithdraw(this, withdraw)) {
            lock.unlock();
            return false;
        }
        this.setBalance(this.getBalance() - withdraw);
        lock.unlock();
        return true;
    }

    private boolean checkWithdraw(Account account, double withdraw) {
        if (account.getBalance() - withdraw < 0) {
            System.out.println("Insufficient funds");
            return false;
        }
        return true;
    }
}
