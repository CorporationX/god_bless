package school.faang.bjs2_81646;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        String[] names = {"Шелдон", "Леонард", "Говард", "Лало"};
        String[] tasks = {"подготовка теории", "моделирование эксперимента",
                "разработка инструментов", "анализ данных"};

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < names.length; i++) {
            executor.submit(new Task(names[i], tasks[i]));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
