package school.faang.supportanimals;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_NUM = 4;
    private static final long AWAIT_TERMINATION_TIME_OUT = 30;
    private static final long ITERATION_NUM = 100;

    public static void main(String[] args) {
        Organization organization = new Organization();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        Runnable firstTask = () -> {
            for (int i = 0; i < ITERATION_NUM; i++) {
                organization.addDonation(10.5);
            }
        };
        Runnable secondTask = () -> {
            for (int i = 0; i < ITERATION_NUM; i++) {
                organization.addDonation(20.0);
            }
        };
        Runnable thirdTask = () -> {
            for (int i = 0; i < ITERATION_NUM; i++) {
                organization.addDonation(15.75);
            }
        };

        executorService.submit(firstTask);
        executorService.submit(secondTask);
        executorService.submit(thirdTask);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_TIME_OUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            log.error("Поток был прерван во время ожидания завершения выполнения всех задач", e);
            throw new RuntimeException(e);
        }

        log.info("Итоговый баланс организации: {}", organization.getBalance().get());
    }
}
