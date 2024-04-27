package faang.school.godbless.banks;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account account1 = new Account(200);
        Account account2 = new Account(234);
        Account account3 = new Account(900);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        List<Account> accounts = List.of(account1, account2, account3);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        CountDownLatch countDownLatch = new CountDownLatch(accounts.size() - 1);

        for (int i = 0; i < accounts.size() - 1; i++) {
            int currentAccountId = i;
            executorService.execute(() -> {
                Account from = accounts.get(currentAccountId);
                Account to = accounts.get(currentAccountId + 1);

                boolean isSuccess = bank.transfer(from.getId(), to.getId(), 230);
                if (!isSuccess) {
                    log.error("Transaction failed");
                } else {
                    log.error("Transaction success");
                }

                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();

        accounts.forEach(account -> log.info(String.valueOf(bank.getTotalBalance(account.getId()))));
    }
}
