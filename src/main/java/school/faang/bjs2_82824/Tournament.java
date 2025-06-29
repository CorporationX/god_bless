package school.faang.bjs2_82824;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Tournament {
    private final Random random = new Random();

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            List<Student> team = school.team();
            Student studentWhoGoOnTask = team.get(random.nextInt(team.size()));
            studentWhoGoOnTask.compiledTask(task);
            return school;
        }, executor);
    }
}
