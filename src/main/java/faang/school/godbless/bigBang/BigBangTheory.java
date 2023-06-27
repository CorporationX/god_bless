package faang.school.godbless.bigBang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Шелдон", "Подготовка теории");
        Task task2 = new Task("Леонард", "Моделирование эксперимента");
        Task task3 = new Task("Говард", "Разработка инструментов");
        Task task4 = new Task("Раджеш", "Анализ данных");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        for (Task task : tasks) {
            service.submit(task);
        }
        service.shutdown();
        try {
            if(service.awaitTermination(1002, TimeUnit.MILLISECONDS)) {
                System.out.println("Программа завершена!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
