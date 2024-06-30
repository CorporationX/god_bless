package faang.school.godbless.play_bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_NUM = 8;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        Bank bank = new Bank();
        List<Account> accountList = getAccountList();
        bank.addAccounts(accountList);

        List<CompletableFuture<Boolean>> futureTransferResults = new ArrayList<>();

        for (int i = 1; i <= accountList.size(); i++) {
            for (int j = i + 1; j <= accountList.size(); j++) {
                int senderId = i;
                int receiverId = j;

                futureTransferResults.add(
                        CompletableFuture.supplyAsync(
                                () -> bank.transfer(senderId, receiverId, 500), executorService)
                );
            }
        }

        executorService.shutdown();

        futureTransferResults.forEach(futureResult -> System.out.println(futureResult.join()));

        System.out.println(bank.getAccounts());
    }

    private static List<Account> getAccountList() {
        return List.of(
                new Account(1, 1000),
                new Account(2, 1000),
                new Account(3, 1000),
                new Account(4, 1000),
                new Account(5, 1000)
        );
    }
}
