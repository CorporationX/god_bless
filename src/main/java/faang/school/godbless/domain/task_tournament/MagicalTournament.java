package faang.school.godbless.domain.task_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student harryPotter = new Student("Harry Potter", 5, 100);
        Student hermioneGranger = new Student("Hermione Granger", 5, 120);
        Student ronWeasley = new Student("Ron Weasley", 5, 80);

        Student fleurDelacour = new Student("Fleur Delacour", 7, 160);
        Student gabrielleDelacour = new Student("Gabrielle Delacour", 5, 100);
        Student rogerDavies = new Student("Roger Davies", 6, 110);

        School hogwarts = new School("Hogwarts", List.of(harryPotter, hermioneGranger, ronWeasley));
        School beauxbatons = new School("Beauxbatons", List.of(fleurDelacour, gabrielleDelacour, rogerDavies));

        Task task1 = new Task("Поиск философского камня", 5, 20);
        Task task2 = new Task("Поиск чаши огня", 7, 30);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);


        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.name() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.name() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
