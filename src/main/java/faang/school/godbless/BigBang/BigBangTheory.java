package faang.school.godbless.BigBang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);


        Task sheldonTask = new Task("Шелдон", "Подготовка теориии");
        Task leondardTask = new Task("Леонард", " моделирование эксперимента.");
        Task govardTask = new Task("Говард", "разработка инструментов");
        Task radgeTask = new Task("Раджеш", " Анализ данных");

        executor.execute(sheldonTask);
        executor.execute(leondardTask);
        executor.execute(govardTask);
        executor.execute(radgeTask);

        executor.shutdown();

    }
}
