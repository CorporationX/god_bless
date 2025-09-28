package school.faang.bjs2_93550;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        List<CompletableFuture<Account>> allAccounts = List.of(
                bank.addAccount(new Account(10000)),
                bank.addAccount(new Account(197.23)),
                bank.addAccount(new Account(6521.78)),
                bank.addAccount(new Account(2322.01))
        );
        CompletableFuture.allOf(allAccounts.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Все аккаунты созданы"))
                .thenRun(() -> {
                    try {
                        log.info("Итоговый баланс в банке: {}", bank.getTotalBalance());
                    } catch (InterruptedException | ExecutionException e) {
                        log.error("Итоговый баланс в банке не удалось посчитать: {}", e.getMessage());
                    }
                })
                .join();

        bank.transfer(2, 3, 200);
        bank.transfer(1, 2, 1000.50);
        bank.transfer(3, 5, 300);
        bank.transfer(3, 4, 300);
        bank.transfer(1, 4, 9000);
        bank.transfer(3, 2, 857.15);
        bank.transfer(7, 2, 5000);

        bank.shutdownCorrectly();
    }
}
