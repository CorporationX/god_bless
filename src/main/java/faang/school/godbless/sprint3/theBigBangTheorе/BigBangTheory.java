package faang.school.godbless.sprint3.theBigBangTheorе;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final List<Task> tasks = List.of(new Task("Шелдон", "подготовка теории"),
            new Task("Леонард","моделирование эксперимента"),
            new Task("Говард","разработка инструментов"),
            new Task("Раджеш","анализ данных"));

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
        tasks.forEach(executor::execute);
        executor.shutdown();

        while (true) {
            if (executor.isTerminated()) {
                System.out.println("Все задачи выполнены");
                break;
            }
        }
    }
}
