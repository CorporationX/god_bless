package faang.school.godbless.play_bank;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

@Slf4j
@Getter
public class Bank {
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int senderAccountId, int receiverAccountId, int transferAmount) {
        Lock firstLock = accounts.get(Math.min(senderAccountId, receiverAccountId)).getLock();
        Lock secondLock = accounts.get(Math.max(senderAccountId, receiverAccountId)).getLock();

        firstLock.lock();
        secondLock.lock();

        if (!accounts.containsKey(senderAccountId)) {
            log.warn("Could not find Account sending money by id");
            return false;
        }

        if (!accounts.containsKey(receiverAccountId)) {
            log.warn("Could not find Account receiving money by id");
            return false;
        }

        Account sender = accounts.get(senderAccountId);
        Account receiver = accounts.get(receiverAccountId);

        try {
            sender.withdraw(transferAmount);
            receiver.deposit(transferAmount);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info(senderAccountId + " SENT " + receiverAccountId + " at: " + LocalDateTime.now());
            return true;
        } catch (IllegalArgumentException e) {
            log.warn("Transfer failed: " + e.getMessage());
            return false;
        } finally {
            secondLock.unlock();
            firstLock.unlock();
        }
    }

    public void addAccounts(List<Account> accountList) {
        accountList.forEach(account -> accounts.put(account.getId(), account));
    }
}
