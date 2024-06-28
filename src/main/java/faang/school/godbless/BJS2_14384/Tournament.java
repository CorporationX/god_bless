package faang.school.godbless.BJS2_14384;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class Tournament {
    private final static int TASK_DURATION_ONE_LEVEL_DIFFICULTY_IN_MILLISECONDS = 1000;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student potter = new Student("Potter", 1, 0);
        Student granger = new Student("Granger", 1, 0);
        Student weasley = new Student("Weasley", 1, 0);

        Student delacour = new Student("Delacour", 2, 0);
        Student castillon  = new Student("Castillon", 2, 0);
        Student dumont = new Student("Dumont", 2, 0);

        School hogwarts = new School("Hogwarts", List.of(potter, granger, weasley));
        School beauxbatons = new School("Beauxbatons", List.of(delacour, castillon, dumont));

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, new Task("HogwartsTask", 1, 12));
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, new Task("BeauxbatonsTask", 2, 14));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        int reward = task.getReward();
        int duration = task.getDifficulty() * TASK_DURATION_ONE_LEVEL_DIFFICULTY_IN_MILLISECONDS;
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + " Interrupted while waiting for task");
                Thread.currentThread().interrupt();
            }
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + reward));
            return school;
        });
    }
}
