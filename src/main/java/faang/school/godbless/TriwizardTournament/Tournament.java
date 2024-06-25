package faang.school.godbless.TriwizardTournament;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private static final Random RANDOM = new Random();
    private static ExecutorService service = Executors.newFixedThreadPool(4);
    public CompletableFuture<School> startTask(School school, Task task){
        List<Student> students = school.getTeam();
        int rewardOneStudent = task.getReward() / students.size();
        CompletableFuture<Student>[] completableFutures = new CompletableFuture[students.size()];
        int index = 0;
        for (Student student : students) {
            completableFutures[index++] = CompletableFuture.supplyAsync(() -> student.setPoints(student.getPoints() + rewardOneStudent), service);
        }
    }
}

