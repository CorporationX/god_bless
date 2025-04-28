package school.faang.they_were_very_nice_but_extremely_poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин",
            "выгулять собаку", "постирать белье"};
    private static final int AWAIT_TERMINATION_TIMEOUT_MINUTES = 1;
    private static final String TIMEOUT_MESSAGE = "Не все задачи завершились за %d минуту(ы)!";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(CHORES)
                .forEach(choreName -> executor.submit(new Chore(choreName)));

        gracefullyShutdown(executor);
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                System.err.printf(TIMEOUT_MESSAGE, AWAIT_TERMINATION_TIMEOUT_MINUTES);
                System.err.println(); // Add a newline after printf
                executor.shutdownNow();
            } else {
                System.out.println("Все задачи успешно выполнены!");
            }
        } catch (InterruptedException e) {
            System.err.println("Прерывание при ожидании завершения задач.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}