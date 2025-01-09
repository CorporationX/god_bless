package school.faang.bjs251105;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<Account> accounts = Arrays.asList(
                new Account(1, 200.9),
                new Account(2, 400.0)
        );

        Bank bank = new Bank();
        accounts.forEach(bank::addAccount);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->
                bank.transfer(2, 1, 100));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() ->
                bank.transfer(1, 2, 50));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);

        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        bank.getTotalBalance();
    }
}