package faang.school.godbless.thread4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Task> tasks = makeTasks();
        tasks.forEach(executor::execute);
        executor.shutdown();
    }

    private static List<Task> makeTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Шелдон", "подготовка теории"));
        tasks.add(new Task("Леонард", "моделирование эксперимента"));
        tasks.add(new Task("Говард", "разработка инструментов"));
        tasks.add(new Task("Раджеш", "анализ данных"));
        return tasks;
    }
}
