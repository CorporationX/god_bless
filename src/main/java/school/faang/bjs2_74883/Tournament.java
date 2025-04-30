package school.faang.bjs2_74883;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
public class Tournament {
    private static final int THREADS = 2;
    private static final int THREAD_SLEEP_EASY = 1000;
    private static final int THREAD_SLEEP_MED = 3000;
    private static final int THREAD_SLEEP_HARD = 4000;
    private List<Task> tasks;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            switch (task.getDifficulty()) {
                case EASY -> {
                    System.out.printf("%s started doing an EASY task\n", school.getName());
                    changeStudentScore(school.getTeam(), 1, THREAD_SLEEP_EASY);
                }
                case MEDIUM -> school.getTeam().forEach(student -> {
                    System.out.printf("%s started doing an MEDIUM task\n", school.getName());
                    changeStudentScore(school.getTeam(), 2, THREAD_SLEEP_MED);
                });
                case HARD -> school.getTeam().forEach(student -> {
                    System.out.printf("%s started doing an HARD task\n", school.getName());
                    changeStudentScore(school.getTeam(), 3, THREAD_SLEEP_HARD);
                });
                default -> school.getTeam().forEach(student -> student.setPoints(0));
            }
            return school;
        }, executor);
    }

    private void changeStudentScore(List<Student> students, int points, int time) {
        try {
            Thread.sleep(time);
            students.forEach(student -> student.setPoints(student.getPoints() + points));
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted while waiting for task", e);
        }

    }
}
