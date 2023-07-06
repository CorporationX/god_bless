package faang.school.godbless.spring_4.triwizard_tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {


    public CompletableFuture<School> startTask(School school, Task task) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        CompletableFuture<School> schoolCompletableFuture = CompletableFuture.supplyAsync(() -> updateStudent(school, task), pool);

        pool.shutdown();

        return schoolCompletableFuture;
    }

    private School updateStudent(School school, Task task) {
        school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
        return school;
    }
}
