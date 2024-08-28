package faang.school.multithreadingparallelismthread.thetriwizardtournament;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        if (school == null || task == null) {
            throw new IllegalArgumentException();
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                sleep(task.getDifficulty() * 1000L);
                school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            return school;
        });

    }
}
