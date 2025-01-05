package school.faang.sprint_4.task_43582;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Произошла ошибка: " + exception.getMessage());
            }

            int hogwartsPoints = 0;
            int beauxbatonsPoints = 0;
            try {
                hogwartsPoints = hogwartsTask.get().getTotalPoints();
                beauxbatonsPoints = beauxbatonsTask.get().getTotalPoints();
            } catch (ExecutionException | InterruptedException e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }

            System.out.println("Общее количество очков Hogwarts: " + hogwartsPoints);
            System.out.println("Общее количество очков Beauxbatons: " + beauxbatonsPoints);
            System.out.println("Победила школа: " + (hogwartsPoints > beauxbatonsPoints ? "Hogwarts" : "Beauxbatons"));
        }).join();
    }
}
