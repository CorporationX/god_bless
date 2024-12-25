package school.faang.sprint1.task_48261;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task sheldon = new Task("Sheldon", "Find topic");
        Task leonard = new Task("Leonard", "Create project");
        Task govard = new Task("Govard", "Check the project");
        Task redjer = new Task("Redjer", "Present the project");
        List<Task> tasks = List.of(sheldon, leonard, govard, redjer);
        for (Task task : tasks) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи выполнены в установленный срок");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
            executor.shutdownNow();
        }
        System.out.println("Задача завершена");

    }
}
