package school.faang.sprint_4.task_51015;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int AMOUNT_OF_TRANSACTIONS = 100;
    private static final int MONEY_PER_TRANSACTION = 100;

    public static void main(String[] args) {
        Bank bank = new Bank();
        Account firstAccount = new Account(1);
        firstAccount.deposit(1000);
        bank.addAccount(firstAccount);

        Account secondAccount = new Account(2);
        secondAccount.deposit(10000);
        bank.addAccount(secondAccount);

        List<CompletableFuture<Boolean>> completableFutures = new ArrayList<>();

        for (int i = 1; i <= AMOUNT_OF_TRANSACTIONS; i++) {
            int finalI = i;
            completableFutures.add(CompletableFuture.supplyAsync(() ->
                    bank.transfer(finalI % 2 + 1,
                            finalI % 2 + 1,
                            finalI * MONEY_PER_TRANSACTION)));
        }

        completableFutures.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);

        System.out.println(bank.getTotalBalance());
    }
}
