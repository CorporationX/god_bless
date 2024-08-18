package faang.school.godbless.modul3.bigbang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Sheldon", "Prepare theory");
        Task leonardTask = new Task("Leonard", "Model experiment");
        Task howardTask = new Task("Howard", "Tool development");
        Task rajeshTask = new Task("Rajesh", "Data analyze");

        List<Task> tasks = List.of(sheldonTask, leonardTask, howardTask, rajeshTask);

        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}
