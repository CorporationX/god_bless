package faang.school.godbless.Big.Bang.Theory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Шелдон", "подготовка теории"));
        taskList.add(new Task("Леонард", "моделирование эксперимента"));
        taskList.add(new Task("Говард", "разработка инструментов"));
        taskList.add(new Task("Раджеш", "анализ данных"));

        for (Task task : taskList) {
            executorService.execute(task);
        }

        executorService.awaitTermination(3, TimeUnit.MILLISECONDS);
        executorService.shutdownNow();
    }
}
