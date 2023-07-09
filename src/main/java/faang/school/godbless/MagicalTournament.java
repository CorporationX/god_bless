package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();


        Student harry = new Student("Harry Potter", 4, 0);
        Student hermione = new Student("Hermione Granger", 5, 0);
        Student ron = new Student("Ron Weasley", 4, 0);

        List<Student> hogwartsTeam = Arrays.asList(harry, hermione, ron);
        School hogwarts = new School("Hogwarts", hogwartsTeam);

        Student fleur = new Student("Fleur Delacour", 6, 0);
        Student cedric = new Student("Cedric Diggory", 6, 0);
        Student victor = new Student("Victor Krum", 7, 0);

        List<Student> beauxbatonsTeam = Arrays.asList(fleur, cedric, victor);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task("Potions", 3, 50);
        Task task2 = new Task("Charms", 4, 70);

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
