package faang.school.godbless.sprint3.BJS2_6309;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        executor.execute(new Task("Шелдон", "подготовка теории"));
        executor.execute(new Task("Леонард", "моделирование эксперимента"));
        executor.execute(new Task("Говард", "разработка инструментов"));
        executor.execute(new Task("Раджеш", "анализ данных"));

        executor.shutdown();
    }
}