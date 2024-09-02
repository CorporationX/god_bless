package bank.game;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void openAccount(@NonNull Account account) {
        if (accounts.containsKey(account.getId())) {
            throw new IllegalArgumentException("Account already added");
        }
        accounts.put(account.getId(), account);
    }

    public void closeAccount(int id) {
        if (!accounts.containsKey(id)) {
            throw new IllegalArgumentException("Don't have this account in bank");
        }
        accounts.remove(id);
    }

    public boolean transfer(int idFrom, int idTo, double amountToTransfer) {
        if (!accounts.containsKey(idFrom) || !accounts.containsKey(idTo)) {
            throw new IllegalArgumentException("Don't have this account in bank");
        }
        Account accountFrom = accounts.get(idFrom);
        accountFrom.getLock().lock();
        try {
            if (accountFrom.getBalance() < amountToTransfer) {
                log.error("Can't transfer from account#{} to account#{}. Not enough money on balance", idFrom, idTo);
                return false;
            }
            accountFrom.withdraw(amountToTransfer);
        } finally {
            accountFrom.getLock().unlock();
        }
        Account accountTo = accounts.get(idTo);
        accountTo.getLock().lock();
        try {
            accountTo.deposit(amountToTransfer);
        } finally {
            accountTo.getLock().unlock();
        }
        return true;
    }

    public double getTotalBalance() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    public List<Integer> getAllIds() {
        return accounts.keySet().stream().toList();
    }
}
