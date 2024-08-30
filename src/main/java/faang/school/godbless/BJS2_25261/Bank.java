package faang.school.godbless.BJS2_25261;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(int id){
        accounts.put(id, new Account(id));
    }

    public List<Account> getAccounts(){
        return accounts.values().stream().toList();
    }

    public boolean transfer(Account from, Account to, int amount) {
        synchronized (from.getLock()) {
            synchronized (to.getLock()) {
                if (from.getBalance() >= amount) {
                    log.info("starting transfer from {} to {}", from, to);
                    from.withdrow(amount);
                    to.deposit(amount);
                    log.info("Transfer from {} to {} was done successful!", from, to);
                    return true;
                } else {
                    log.info("Not enough money to do transfer! Need {}, but balance is {}", amount, from.getBalance());
                    return false;
                }
            }
        }
    }

    public Account getRandomAccount(){
        return accounts.get(ThreadLocalRandom.current().nextInt(0, accounts.size()));
    }

    public int getTotalBalance() {
        return accounts.values().stream().mapToInt(Account::getBalance).sum();
    }
}
