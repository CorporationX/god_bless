package school.faang.sprint4.task_51655;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task(
                "Triwizard Tournament",
                10,
                100
        );
        Task task2 = new Task(
                "Yule Ball Preparations",
                5,
                50
        );

        // Запуск заданий для школ
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("winner is hogwarts");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("winner is beauxbatons");
            } else {
                System.out.println("draw");
            }
            System.out.println("hogwarts points : " + hogwarts.getTotalPoints());
            System.out.println("beauxbatons points : " + beauxbatons.getTotalPoints());
        }).join();
        // Обработка результатов всех заданий и определение победителя
    }
}