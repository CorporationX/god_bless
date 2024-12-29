package school.faang.task_50931;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Tournament {
    private static final long SLEEP_MULTIPLIER = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * SLEEP_MULTIPLIER);
            } catch (InterruptedException e) {
                log.warn("Thread was interrupted", e);
                Thread.currentThread().interrupt();
                throw new CompletionException(e); //так как метод не void, то return тут не катит, поэтому сделал так
                //по совету ChatGPT. Просто возвращать school, который получаем неправильно на мой взгляд
            }

            synchronized (school) {
                for (var student : school.getTeam()) {
                    int updatedPoints = student.getPoints() + task.getReward();
                    student.setPoints(updatedPoints);
                }
                return school;
            }
        });
    }

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                                             new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                                                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenAccept(result -> {
            try {
                int hogwartsPoints = hogwartsTask.get().getTotalPoints();
                int beauxbatonsPoints = beauxbatonsTask.get().getTotalPoints();

                if (hogwartsPoints > beauxbatonsPoints) {
                    System.out.println("hogwarts won with score " + hogwartsPoints + " over " + beauxbatonsPoints);
                } else if (hogwartsPoints < beauxbatonsPoints) {
                    System.out.println("beauxbatons won with score " + beauxbatonsPoints + " over " + hogwartsPoints);
                } else {
                    System.out.println("it's a draw " + beauxbatonsPoints + " to " + hogwartsPoints);
                }

            } catch (ExecutionException e) {
                log.error("ExecutionException occurred", e);
            } catch (InterruptedException e) {
                log.warn("Main thread was interrupted", e);
            }
        }).join();
    }
}
