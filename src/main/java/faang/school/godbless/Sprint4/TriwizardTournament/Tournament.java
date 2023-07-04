package faang.school.godbless.Sprint4.TriwizardTournament;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.between;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) throws InterruptedException {
        LocalDateTime limit = LocalDateTime.now().plusSeconds(10);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Student student : school.getTeam()) {
            student.setDoing(true);
            executorService.execute(() -> student.studentDoing(task));
        }
        executorService.awaitTermination(between(LocalDateTime.now(), limit).toMillis(), TimeUnit.MILLISECONDS);
        executorService.shutdown();

        for (Student student : school.getTeam()) {
            student.setDoing(false);
        }
        return CompletableFuture.completedFuture(school);
    }
}
