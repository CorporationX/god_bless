package faang.school.godbless.domain.task_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {


    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(school.name() + " начал задание " + task.name());
            try {
                Thread.sleep(task.difficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(school.name() + " завершил задание " + task.name());
            for (Student student : school.team()) {
                int points = student.points() + task.reward();
            }
            return school;
        });
    }
}
