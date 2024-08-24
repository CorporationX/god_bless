package faang.school.godbless.task25899;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Task("Подготовка теории", "Шелдон"));
        executorService.execute(new Task("Разработка инструментов", "Говард"));
        executorService.execute(new Task("Моделирование эксперимента", "Леонард"));
        executorService.execute(new Task("Анализ данных", "Раджеш"));
        executorService.shutdown();
    }
}
