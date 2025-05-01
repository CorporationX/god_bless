package school.faang.tournament_of_the_three_wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {

            List<Student> team = school.getTeam();

            for (Student student : team) {
                int pointsEarned = task.completeTask();
                student.addPoints(pointsEarned);
            }
            return school;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
