package school.faang.play_banking;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Account> accounts = List.of(
                new Account(1, 1000.0),
                new Account(2, 2000.0),
                new Account(3, 3000.0),
                new Account(4, 4000.0)
        );

        accounts.forEach(bank::addAccount);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        Runnable task = () -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int fromAccountId = random.nextInt(4) + 1; // Случайный счёт от 1 до 4
                int toAccountId = random.nextInt(4) + 1;   // Случайный счёт от 1 до 4
                double amount = random.nextInt(500);       // Случайная сумма до 500

                if (fromAccountId != toAccountId) {
                    bank.transfer(fromAccountId, toAccountId, amount);
                }
            }
        };

        // Запускаем 4 потока
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            executor.submit(task);
        }

        // Завершаем работу пула потоков
        executor.shutdown();
        try {
            if (executor.awaitTermination(3, TimeUnit.SECONDS)) {
                log.info("Complete");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Tasks completed with errors {}", e.getMessage());
        }

        // Вывод общего баланса
        System.out.println("Общий баланс всех счетов: " + bank.getTotalBalance());

//        System.out.println(bank.getTotalBalance());

    }
}
