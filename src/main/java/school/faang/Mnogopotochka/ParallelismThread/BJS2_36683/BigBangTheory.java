package school.faang.Mnogopotochka.ParallelismThread.BJS2_36683;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final List<Task> tasks = new ArrayList<>();
    public static void main(String[] args) {
        addTask(new Task("Sheldon", "Preparation of theory"));
        addTask(new Task("Leonard", "Modeling of experiment"));
        addTask(new Task("Howard", "Development of tools"));
        addTask(new Task("Rajesh", "Data analysis"));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        tasks.forEach(executorService::submit);

        executorService.shutdown();
    }

    private static void addTask(Task task){
        tasks.add(task);
    }
}
