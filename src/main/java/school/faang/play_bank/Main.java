package school.faang.play_bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int FIXED_THREAD = 10;

    public static void main(String[] args) {
        Bank bank = new Bank();
        Account account1 = new Account(1, 250);
        Account account2 = new Account(2, 300);
        Account account3 = new Account(3, 600);
        Account account4 = new Account(4, 400);
        Account account5 = new Account(5, 800);
        List<Account> accountList = new ArrayList<>(List.of(account1, account2, account3, account4, account5));

        bank.addAccount(account1, account2, account3, account4, account5);

        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(FIXED_THREAD);


        List<CompletableFuture<Account>> futureList = new ArrayList<>();
        for (int i = 0; i < accountList.size() - 1; i++) {
            int index = i;
            CompletableFuture<Account> completableFuture = CompletableFuture.supplyAsync(() -> {
                bank.transfer(accountList.get(index).getId(),
                        accountList.get(index + 1).getId(),
                        random.nextDouble(500));
                return accountList.get(index);
            }, service);
            futureList.add(completableFuture);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allOf.join();

        service.shutdown();
    }
}
