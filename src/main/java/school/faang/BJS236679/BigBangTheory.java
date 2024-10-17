package school.faang.BJS236679;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        String[] names = {"Шелдон", "Леонард", "Говард", "Раджеш"};
        String[] job  = {"Подготовка теории", "моделирование эксперимента", "разработка инструментов", "анализ данных"};
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < 4 ; i++) {
            tasks.add(new Task(names[i], job[i]));
        }

        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}
