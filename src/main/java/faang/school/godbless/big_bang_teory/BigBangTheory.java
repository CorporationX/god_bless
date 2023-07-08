package faang.school.godbless.big_bang_teory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Task("Шелдон", "подготовка теории"));
        executorService.execute(new Task("Леонард", "моделирование эксперимента"));
        executorService.execute(new Task("Говард", "разработка инструментов"));
        executorService.execute(new Task("Раджеш", "анализ данных"));

        executorService.shutdown();
        try {
            executorService.awaitTermination(25, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все задания выполнены");
    }
}
