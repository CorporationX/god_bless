package school.faang.bjs274991;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s begin %s (%s)%n", school.getName(), task.getName(), Thread.currentThread().getName());
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.setPoints(student.getPoints() + task.getReward() / school.getTeam().size());
            }
            System.out.printf("%s end %s (%s)%n", school.getName(), task.getName(), Thread.currentThread().getName());
            school.setFinishTime(System.currentTimeMillis());

            return school;
        });
    }
}

