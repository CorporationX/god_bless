package school.faang.task424;

import school.faang.task424.account.Account;
import school.faang.task424.bank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            bank.addAccount(new Account(random.nextDouble(500)));
        }
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(CompletableFuture.runAsync(() -> {
                bank.transfer(random.nextInt(5), random.nextInt(5), BigDecimal.valueOf(random.nextDouble(88)));
            }, service));
        }

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();

        System.out.println("Баланс банка " + bank.getTotalBalance());
        service.shutdown();
    }
}
