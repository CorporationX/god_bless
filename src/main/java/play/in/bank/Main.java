package play.in.bank;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    private final static int MAX_TRANSFER_AMOUNT = 5000;

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setAccount(new Account(1, 2000));
        bank.setAccount(new Account(2, 3000));
        bank.setAccount(new Account(3, 4000));
        bank.setAccount(new Account(4, 5000));
        bank.setAccount(new Account(5, 1000));

        Random random = new Random();
        Map<Integer, Account> accounts = bank.getAccounts();

        for (int i = 0; i < accounts.size(); i++) {
            CompletableFuture.supplyAsync(() -> bank.transfer(
                accounts.get(random.nextInt(1, accounts.size())),
                accounts.get(random.nextInt(1, accounts.size())),
                random.nextInt(1, MAX_TRANSFER_AMOUNT)
            )).thenAccept((result) -> {
                if (result) {
                    System.out.println("Успешный перевод");
                } else {
                    System.err.println("При переводе произошла ошибка");
                }
            }).join();
        }

        System.out.println(bank.getAccounts());
        System.out.println(bank.getTotalBalance());
    }
}
