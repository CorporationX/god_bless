package faang.school.godbless.Sprint_5.Multithreading_Async.TriWizardTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        School hogwarts = new School("Hogwarts", List.of(new Student("Harry", 4, 0), new Student("Cedric", 6, 0)));
        School beauxbatons = new School("Beauxbaton", List.of(new Student("Fleur Delacour", 6, 0), new Student("Gabrielle Delacour", 3, 0)));
        Task task1 = new Task("first", 3,100);
        Task task2 = new Task("second", 4,140);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
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
}
