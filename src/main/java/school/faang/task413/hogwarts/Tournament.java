package school.faang.task413.hogwarts;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        int totalSecond = 1000;
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) totalSecond * task.getDifficult());
                school.getStudents()
                        .forEach(student -> student.completeTask(task.getReward()));
                return school;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
