package faang.school.godbless.triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s: %s students started task %s\n", Thread.currentThread().getName(), school.getName(), task.getName());
                Thread.sleep(task.getDifficulty() * 100L);

                school.getStudents().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
                System.out.printf("%s: %s students completed task %s. For each student added %d points\n",
                        Thread.currentThread().getName(),
                        school.getName(),
                        task.getName(),
                        task.getReward()
                );

                return school;
            } catch (InterruptedException e) {
                throw new RuntimeException(String.format("%s: %s failed doing task %s\n", Thread.currentThread().getName(), school.getName(), task.getName()));
            }
        });
    }
}
