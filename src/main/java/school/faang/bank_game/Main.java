package school.faang.bank_game;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Map<Integer, Account> accounts = new HashMap<>();
        accounts.put(1, new Account(1, 1000.0));
        accounts.put(2, new Account(2, 500.0));
        accounts.put(3, new Account(3, 0.0));

        Bank bank = new Bank(accounts);

        log.info("Перевод 300 от Account 1 к Account 2:");
        Future<Boolean> result1 =  executorService.submit(() ->
                bank.transfer(1, 2, 300));

        log.info("Перевод 800 от Account 2 к Account 3:");
        Future<Boolean> result2 =  executorService.submit(() ->
                bank.transfer(2, 3, 800));

        log.info("Перевод 200 от Account 2 к Account 3:");
        Future<Boolean> result3 =  executorService.submit(() ->
                bank.transfer(2, 3, 200));

        try {
            log.info("Успех: " + result1.get());
            log.info("Успех: " + result2.get());
            log.info("Успех: " + result3.get());
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
        }

        double total = bank.getTotalBalance();
        log.info("Общий баланс в банке: " + total);

        executorService.shutdown();
    }
}
