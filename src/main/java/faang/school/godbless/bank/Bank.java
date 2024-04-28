package faang.school.godbless.bank;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    @SneakyThrows
    public boolean transfer(@NonNull Integer from, @NonNull Integer to, int sum) {
        ReentrantLock lock = new ReentrantLock();
        if (accounts.containsKey(from) && accounts.containsKey(to)) {
            if (accounts.get(from).getBalance() < sum) {
                log.info("Lack of funds from {} to {} for transfer, sum: {}", from, to, sum);
                return false;
            }
            lock.lock();
            try {
                accounts.get(from).withdraw(sum);
                accounts.get(to).deposit(sum);
                TimeUnit.SECONDS.sleep(3);
                log.info("The transfer from {} to {} be completed, sum: {}", from, to, sum);
                return true;
            } finally {
                lock.unlock();
            }

        } else {
            log.info("The transfer could not be completed due to the absence of such users");
            return false;
        }
    }

    public void addAccount(@NonNull Account account) {
        accounts.put(account.getId(), account);
    }

    public int getTotalBalance() {
        return accounts.values().stream().map(Account::getBalance).reduce(0, Integer::sum);
    }

    public void printAllAccounts() {
        synchronized (accounts) {
            accounts.forEach((key, value) -> System.out.println(key + ": Balance=" + value.getBalance()));
        }
    }
}
