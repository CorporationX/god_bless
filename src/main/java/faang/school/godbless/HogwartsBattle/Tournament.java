package faang.school.godbless.HogwartsBattle;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public static CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            updateStudentsPoints(school, task);
            return school;
        });
        return future;
    }

    private static void updateStudentsPoints(School school, Task task) {
        school.getTeam().forEach(student -> student.addPonits(task.getReward()));
    }



}
