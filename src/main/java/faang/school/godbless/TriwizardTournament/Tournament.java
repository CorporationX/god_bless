package faang.school.godbless.TriwizardTournament;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newFixedThreadPool(school.getTeam().size());
        CompletableFuture<School> schoolCompletableFuture = new CompletableFuture<>();
        for (Student student : school.getTeam()) {
            schoolCompletableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println(student.getName() + " начинает выполнять задание " + task.getName() + " в потоке " + Thread.currentThread().getName());
                    Thread.sleep(3000);
                    int pointInTask = task.getReward() * task.getDifficulty() * new Random().nextInt(10);
                    System.out.println(student.getName() + " получает " + pointInTask + " очков");
                    student.setPoints(pointInTask);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return school;
            }, executor);
        }
        executor.shutdown();
        return schoolCompletableFuture;
    }
}
