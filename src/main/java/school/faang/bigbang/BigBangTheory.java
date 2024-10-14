package school.faang.bigbang;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int MAX_TIME_FOR_WAIT = 1000;
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Шелдон","подготовка теории"));
        tasks.add(new Task("Леонард","моделирование эксперимента"));
        tasks.add(new Task("Говард","разработка инструментов"));
        tasks.add(new Task("Раджеш","анализ данных"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (Task task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(MAX_TIME_FOR_WAIT, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи успели завершиться, принудительно останавливаем выполнение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
