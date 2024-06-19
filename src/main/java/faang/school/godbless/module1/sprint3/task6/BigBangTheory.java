package faang.school.godbless.module1.sprint3.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasksOrder = new ArrayList<>();
        tasksOrder.add(new Task("Sheldon", "Take measurements"));
        tasksOrder.add(new Task("Leonard", "Wash the test tubes"));
        tasksOrder.add(new Task("Howard", "Write documentation"));
        tasksOrder.add(new Task("Rajesh", "Build a bomb shelter"));
        executeTasks(tasksOrder);

    }

    public static void executeTasks(List<Task> tasks) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        tasks.forEach(service::execute);
        service.shutdown();
    }
}
