package faang.school.godbless.BJS2_12342;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Sheldon", "Preparing of theory");
        Task leonardTask = new Task("Leonard", "Experiment modelling");
        Task howardTask = new Task("Howard", "Tools development");
        Task radjeshTask = new Task("Radjesh", "Data analysis");
        List<Task> taskList = List.of(sheldonTask, leonardTask, howardTask, radjeshTask);
        taskList.forEach(service::submit);
        service.shutdown();
        try {
            service.awaitTermination(60, TimeUnit.SECONDS);
            if (service.isTerminated()) {
                System.out.println("All tasks were complete");
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
