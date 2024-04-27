package faang.school.godbless.concurrency.banking;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new Account(1, 100));
        bank.addAccount(new Account(2, 1000));
        bank.addAccount(new Account(3, 600));
        bank.addAccount(new Account(4, 300));
        bank.addAccount(new Account(5, 70));

        final int accountsNum = bank.getAccounts().size();

        List<CompletableFuture<Void>> transferTasks = new ArrayList<>();

        log.info("Let operations begin!");

        for (int i = 0; i < accountsNum; i++) {
            transferTasks.add(CompletableFuture.runAsync(() -> {
                int senderId = ThreadLocalRandom.current().nextInt(1, accountsNum);
                int recipientId = ThreadLocalRandom.current().nextInt(1, accountsNum);
                int transferAmount = ThreadLocalRandom.current().nextInt(1, 1000);

                bank.transfer(senderId, recipientId, transferAmount);
            }));
        }

        CompletableFuture.allOf(transferTasks.toArray(new CompletableFuture[0])).join();

        log.info("Operations are over.");
    }
}
