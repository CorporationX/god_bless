package triwizardTournament_1248;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureResult = new CompletableFuture<>();

        for (Student student : school.getTeam()) {
            futureResult = CompletableFuture.supplyAsync(() -> {
                executeTask(student, task);
                return school;
            });
        }
        return futureResult;
    }

    public static void executeTask(Student student, Task task) {
        try {
            System.out.println(student.getName() + " выполняет задание - " + task.getName());
            Thread.sleep((long) 1000 * task.getDifficulty());
            student.setPoints(student.getPoints() + task.getReward());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}