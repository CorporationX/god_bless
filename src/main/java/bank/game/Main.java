package bank.game;

import lombok.NonNull;
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
        addAccounts(accounts, bank);
        proceedTransfers(bank);
    }

    private static void addAccounts(@NonNull List<Account> accounts, @NonNull Bank bank) {
        var futures = accounts.stream()
                .map(account -> CompletableFuture.runAsync(() -> bank.openAccount(account)))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private static void proceedTransfers(@NonNull Bank bank) {
        var transferFutures = IntStream.range(0, ACCOUNTS_COUNT)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> sendTransfer(bank)))
                .toList();
        CompletableFuture.allOf(transferFutures.toArray(new CompletableFuture[0])).join();
        transferFutures.stream()
                .map(CompletableFuture::join)
                .forEach(Main::handleResult);
    }

    private static boolean sendTransfer(@NonNull Bank bank) {
        var ids = bank.getAllIds();
        int idFrom = ids.get(ThreadLocalRandom.current().nextInt(ids.size()));
        int idTo = ids.get(ThreadLocalRandom.current().nextInt(ids.size()));
        log.info("{} {}", idFrom, idTo);
        if (idFrom != idTo) {
            return bank.transfer(idFrom, idTo,
                    ThreadLocalRandom.current().nextDouble() * 200.0 + 1.0);
        }
        log.error("Same id");
        return false;
    }

    private static void handleResult(boolean result) {
        if (result) {
            log.info("Transaction successful");
        } else {
            log.error("Transaction failed");
        }
    }

    private static List<Account> initAccount() {
        return IntStream.range(0, ACCOUNTS_COUNT)
                .mapToObj(i -> new Account())
                .toList();
    }
}
