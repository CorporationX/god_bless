package school.faang.weasleyfamily81240;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int VALUE_SLEEP = 1;
    private static final int VALUE_AWAIT_TERMINATION = 1;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("начинаем работу");
        ExecutorService executor = Executors.newFixedThreadPool(WeasleyFamily.getChores().length);
        for (Chore chore : WeasleyFamily.getChores()) {
            Thread.sleep(VALUE_SLEEP);
            executor.submit(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(VALUE_AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.printf("Не все задачи завершены за %s секунд. Завершаем принудительно...%n",
                        VALUE_AWAIT_TERMINATION);

            } else {
                Thread.sleep(VALUE_SLEEP);
                System.out.println("все задачи выполнены");
            }
        } catch (InterruptedException e) {
            System.out.printf("Ожидание завершения потоков прервано.%n");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
