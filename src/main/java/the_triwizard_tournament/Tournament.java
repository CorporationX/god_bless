package the_triwizard_tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    /**
     * Starts a task for a school.
     *
     * The task is run asynchronously and will complete after a delay equal to the task's difficulty
     * in seconds. When the task is completed, the points of each student in the school are increased
     * by the task's reward.
     *
     * @param school The school to start the task for.
     * @param task The task to start.
     * @return A future that completes with the school when the task is complete.
     */
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            school.getStudents().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}
