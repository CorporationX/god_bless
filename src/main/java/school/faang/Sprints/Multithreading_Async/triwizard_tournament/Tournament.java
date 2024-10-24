package school.faang.Sprints.Multithreading_Async.triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() +
                    " " + school.getName() +
                    " " + task.getReward());
            school.getStudentList().stream().forEach(student -> student.addPoints(task.getReward()));
            return school;
        });
    }
}
