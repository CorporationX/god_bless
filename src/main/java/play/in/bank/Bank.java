package play.in.bank;

import lombok.Getter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(Account sender, Account recipient, int amount) {
        if (sender.equals(recipient)) {
            System.out.println("Нельзя переводить самому себе!");
            return false;
        }

        Object senderLock = sender.getLock();
        Object recipientLock = recipient.getLock();

        synchronized (senderLock) {
            synchronized (recipientLock) {
                if (sender.getBalance() >= amount) {
                    System.out.printf("Перевод от %s на %s account.\nСумма %s\n", sender.getId(), recipient.getId(), amount);
                    sender.withdraw(amount);
                    recipient.deposit(amount);

                    return true;
                }
                System.err.println("Недостаточно средств на счёте");
            }
        }

        return false;
    }

    public long getTotalBalance() {
        return this.getAccounts().values()
            .stream()
            .mapToLong(Account::getBalance)
            .sum();
    }

    public void setAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
