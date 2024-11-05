package school.faang.play.the.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_OF_TRANSFER_OPERATIONS = 1000;

    public static void main(String[] args) {
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 500);
        Account account3 = new Account(3, 300);
        Account account4 = new Account(4, 1500);
        List<Account> accounts = List.of(account1, account2, account3, account4);

        Bank bank = new Bank();
        bank.add(account1);
        bank.add(account2);
        bank.add(account3);
        bank.add(account4);

        List<CompletableFuture<Boolean>> futures = IntStream.range(0, NUM_OF_TRANSFER_OPERATIONS)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                            List<Account> accountsCopy = new ArrayList<>(accounts);
                            int fromAccountIndx = ThreadLocalRandom.current().nextInt(accountsCopy.size());
                            Account fromAccount = accountsCopy.remove(fromAccountIndx);
                            int toAccountIndx = ThreadLocalRandom.current().nextInt(accountsCopy.size());
                            Account toAccount = accountsCopy.remove(toAccountIndx);
                            return bank.transfer(fromAccount.getId(), toAccount.getId(), 500);
                        }
                ))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Общий баланс всех счетов " + bank.getTotalBalance());
                    System.out.println("все задачи завершены");
                })
                .join();
    }
}
