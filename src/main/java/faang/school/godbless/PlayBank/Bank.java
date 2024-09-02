package faang.school.godbless.PlayBank;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void transfer(int fromId, int toId, int amount) {
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);
        if (fromId < toId) {
            Account temp = from;
            from = to;
            to = temp;
        }
        synchronized (from) {
            synchronized (to) {
                executeTransfer(from, to, amount);
            }
        }
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    private boolean executeTransfer(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println(from.getId() + " успешно перевёл " + amount + " на аккаунт " + to.getId());
                    return true;
                }
            }
        }
        System.out.println(from.getId() + " не смог перевести " + amount + " на аккаунт " + to.getId());
        return false;
    }
}

