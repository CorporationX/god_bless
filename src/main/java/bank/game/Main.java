package bank.game;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int ACCOUNTS_COUNT = 10;

    public static void main(String[] args) {
        var accounts = initAccount();
        Bank bank = new Bank();
        var futures = accounts.stream()
                .map(account -> CompletableFuture.runAsync(() -> bank.openAccount(account)))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        var transferFutures = IntStream.range(0, ACCOUNTS_COUNT)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    var ids = bank.getAllIds();
                    int idFrom = ids.get(ThreadLocalRandom.current().nextInt(ids.size()));
                    int idTo = ids.get(ThreadLocalRandom.current().nextInt(ids.size()));
                    log.info("{} {}", idFrom, idTo);
                    if (idFrom != idTo) {
                        return bank.transfer(idFrom, idTo,
                                ThreadLocalRandom.current().nextDouble() * 100.0 + 1.0);
                    }
                    log.error("Same id");
                    return false;
                }))
                .toList();
        transferFutures.stream()
                .map(CompletableFuture::join)
                .forEach(result -> {
                    if (result) {
                        log.info("Transaction successful");
                    } else {
                        log.error("Transaction failed");
                    }
                });
    }

    private static List<Account> initAccount() {
        return IntStream.range(0, ACCOUNTS_COUNT)
                .mapToObj(i -> new Account())
                .toList();
    }
}
