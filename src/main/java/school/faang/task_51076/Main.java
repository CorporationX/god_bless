package school.faang.task_51076;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREAD_COUNT = 3;
    public static final int PERIOD = 5;
    public static final int DELAY = 10000;
    public static final Random RANDOM = new Random();
    public static final int AMOUNT_BOUND = 100;

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new Account(0, 34));
        bank.addAccount(new Account(1, 104));
        bank.addAccount(new Account(2, 12));
        bank.addAccount(new Account(3, 55));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(THREAD_COUNT);

        int bound = bank.getAccounts().size();

        for (var i = 0; i < THREAD_COUNT; i++) {
            service.scheduleAtFixedRate(() -> {
                int fromAccountId = RANDOM.nextInt(bound);
                int toAccountId = fromAccountId == 0 ? fromAccountId++ : fromAccountId--;
                double amount = RANDOM.nextInt(AMOUNT_BOUND);
                bank.transfer(fromAccountId, toAccountId, amount);
            }, 0, PERIOD, TimeUnit.SECONDS);
        }

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted", e);
        }

        System.out.println(bank.getTotalBalance());

        service.shutdown();
        try {
            if (!service.awaitTermination(DELAY, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
