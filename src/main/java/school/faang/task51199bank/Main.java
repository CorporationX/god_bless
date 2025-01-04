package school.faang.task51199bank;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 4;
    private static final int TERMINATION_TIMEOUT = 1;

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 500);
        Account acc3 = new Account(3, 3000);
        Account acc4 = new Account(4, 1200);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.addAccount(acc4);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);


        Runnable task = () -> {
            Random random = new Random();
            IntStream.range(0, 10)
                    .forEach(num -> {
                        int fromAccountId = random.nextInt(4) + 1;
                        int toAccountId = random.nextInt(4) + 1;
                        double amount = random.nextInt(500);

                        if (fromAccountId != toAccountId) {
                            bank.transfer(fromAccountId, toAccountId, amount);
                        }
                    });


        };

        IntStream.range(0, 4).forEach(num -> executor.submit(task));

        executor.shutdown();

        try {
            if (executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MINUTES)) {

                log.info("Общий баланс всех счетов {}", bank.getTotalBalance());
                log.info("Все операции выполнены успешно! ");
            } else {
                log.error("Задачи выполнены не полностью, остананавливаем потоки принудительно .");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}