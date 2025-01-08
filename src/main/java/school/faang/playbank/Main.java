package school.faang.playbank;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    public static final int THREAD_AMOUNT = 5;
    public static final int AWAIT_TIME = 10;
    public static final double MIN_AMOUNT = 99;
    public static final double MAX_AMOUNT = 10000;

    public static void main(String[] args) {
        Bank bank = new Bank();

        List<Account> accounts = List.of(
                new Account(1, 100),
                new Account(2, 1900),
                new Account(3, 109100),
                new Account(4, 9000),
                new Account(5, 5210)
        );

        accounts.forEach(bank::addAccount);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        Runnable task = () -> {
            for (int i = 0; i < THREAD_AMOUNT; i++) {
                int fromAccountId = accounts.get(RANDOM.nextInt(accounts.size() - 1)).getId();
                int toAccountId = accounts.get(RANDOM.nextInt(accounts.size() - 1)).getId();
                double amount = Double.parseDouble(DECIMAL_FORMAT
                        .format(RANDOM.nextDouble(MIN_AMOUNT, MAX_AMOUNT)));
                bank.transfer(fromAccountId, toAccountId, amount);
            }
        };

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            try {
                if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                    System.out.println("Не все задачи завершены в указанный период времени.");
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }

        log.info("Общий баланс всех счетов: {}", bank.getTotalBalance());
    }
}
