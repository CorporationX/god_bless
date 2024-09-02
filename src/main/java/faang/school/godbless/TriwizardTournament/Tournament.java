// Tournament.java
package faang.school.godbless.TriwizardTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            int totalPoints = school.getTotalPoints();
            if (task.getDifficulty() < totalPoints) {
                for (Student student : school.getTeam()) {
                    student.addPoints(task.getReward());
                }
            }
            return school;
        });
    }

    public static void main(String[] args) {
        Student harry = new Student("Harry", 5, 50);
        Student hermione = new Student("Hermione", 5, 60);
        Student ron = new Student("Ron", 5, 40);

        School hogwarts = new School("Hogwarts", List.of(harry, hermione, ron));

        Task task1 = new Task("Dragon Challenge", 100, 30);
        Task task2 = new Task("Lake Challenge", 80, 20);

        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask1, hogwartsTask2);
        allTasks.thenRun(() -> {
            System.out.println("Total points for " + hogwarts.getName() + ": " + hogwarts.getTotalPoints());
        }).join();
    }
}