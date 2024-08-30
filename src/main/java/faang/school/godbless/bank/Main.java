package faang.school.godbless.bank;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Bank BANK = new Bank();

    private static void asyncTransfer(int fromId, int toId, int amount) {
        CompletableFuture.supplyAsync(
                () -> BANK.transfer(fromId, toId, amount))
                .thenAccept((flag) -> {
                    if (flag) {
                        System.out.println("Transfer from account " + fromId + " to account " + toId + " is successful");
                    } else {
                        System.out.println("Transfer from account " + fromId + " to account " + toId + " failed");
                    }
                });
    }

    public static void main(String[] args) {
        BANK.addAccount(new Account(0, 1000));
        BANK.addAccount(new Account(1, 2000));
        BANK.addAccount(new Account(2, 3000));
        BANK.addAccount(new Account(3, 4000));
        BANK.addAccount(new Account(4, 5000));

        Random random = new Random();
        int accountsCount = BANK.getAccounts().size();

        for (int i = 0; i < 10; i++) {
            asyncTransfer(
                    random.nextInt(accountsCount),
                    random.nextInt(accountsCount),
                    random.nextInt(1000)
            );
        }
    }
}
