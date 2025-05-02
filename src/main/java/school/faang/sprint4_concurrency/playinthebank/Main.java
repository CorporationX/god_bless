package school.faang.sprint4_concurrency.playinthebank;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int ACCOUNT_COUNT = 4;
    private static final int TASK_COUNT = 3;
    private static final int TRANSFER_ITERATIONS = 10;
    private static final int BALANCE_MAX = 500;
    private static final int INITIAL_BALANCE_OFFSET = 1000;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(ACCOUNT_COUNT);

    public static void main(String[] args) {
        ConcurrentMap<Integer, Account> accounts = IntStream.rangeClosed(1, ACCOUNT_COUNT)
                .mapToObj(i -> new Account(i, i + INITIAL_BALANCE_OFFSET))
                .collect(Collectors.toConcurrentMap(Account::getId, Function.identity()));

        Bank bank = new Bank();
        bank.addAccount(accounts);

        Runnable task = () -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            IntStream.range(0, TRANSFER_ITERATIONS).forEach(i -> {
                int fromAccountId = random.nextInt(1, ACCOUNT_COUNT + 1);
                int toAccountId = random.nextInt(1, ACCOUNT_COUNT + 1);
                double balance = random.nextInt(BALANCE_MAX);
                if (fromAccountId != toAccountId) {
                    if (bank.transfer(fromAccountId, toAccountId, balance)) {
                        log.info("Успешно!!!");
                    } else {
                        log.error("Ошибка. Попробуй еще раз!");
                    }
                } else {
                    log.warn("Ошибка: Счет списания и назначения одинаковый (id={}).", fromAccountId);
                }
            });
        };

        IntStream.range(0, TASK_COUNT).forEach(i -> executorService.submit(task));

        shutdown();

        System.out.println("Общий баланс всех счетов: " + bank.getTotalBalance());
    }

    private static void shutdown() {
        Main.executorService.shutdown();
        try {
            if (!Main.executorService.awaitTermination(50, TimeUnit.SECONDS)) {
                Main.executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Main.executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}