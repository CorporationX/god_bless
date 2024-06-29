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
    private final long CHECKING_TIME = 1000L;
    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public boolean transfer(int senderAccountId, int receiverAccountId, int transferAmount) {
        Lock accoutWithMinIdLock = accounts.get(Math.min(senderAccountId, receiverAccountId)).getLock();
        Lock accoutWithMaxIdLock = accounts.get(Math.max(senderAccountId, receiverAccountId)).getLock();

        accoutWithMinIdLock.lock();
        accoutWithMaxIdLock.lock();

        try {
            checkAreAccountsValid(senderAccountId, receiverAccountId);
            processTransaction(senderAccountId, receiverAccountId, transferAmount);
            Thread.sleep(CHECKING_TIME);
            log.info(senderAccountId + " SENT " + receiverAccountId + " at: " + LocalDateTime.now());
            return true;
        } catch (IllegalArgumentException | InterruptedException e) {
            log.warn("Transfer failed: " + e.getMessage());
            return false;
        } finally {
            accoutWithMaxIdLock.unlock();
            accoutWithMinIdLock.unlock();
        }
    }

    public void addAccounts(List<Account> accountList) {
        accountList.forEach(account -> accounts.put(account.getId(), account));
    }

    private void checkAreAccountsValid(int senderAccountId, int receiverAccountId) {
        if (!accounts.containsKey(senderAccountId)) {
            throw new IllegalArgumentException("Could not find Account sending by id");
        }

        if (!accounts.containsKey(receiverAccountId)) {
            throw new IllegalArgumentException("Could not find Account receiver by id");
        }
    }

    private void processTransaction(int senderAccountId, int receiverAccountId, int transferAmount) {
        Account sender = accounts.get(senderAccountId);
        Account receiver = accounts.get(receiverAccountId);

        sender.withdraw(transferAmount);
        receiver.deposit(transferAmount);
    }
}
