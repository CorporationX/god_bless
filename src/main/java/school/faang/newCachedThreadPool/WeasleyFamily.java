package school.faang.newCachedThreadPool;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {
            "помыть посуду ",
            "подмести пол ",
            "приготовить ужин ",
            "постирать одежду ",
            "полить цветы "
    };

    @SuppressWarnings("checkstyle:LineLength")
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(CHORES)
                .filter(chore -> chore != null && !chore.trim().isEmpty())
                .forEach(chore -> executor.submit(new Chore(chore)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.err.println("Не все задачи завершились в течение отведённого времени!");
            }
        } catch (InterruptedException e) {
            System.err.println("Ожидание завершения было прервано");
            Thread.currentThread().interrupt();
        }
    }
}