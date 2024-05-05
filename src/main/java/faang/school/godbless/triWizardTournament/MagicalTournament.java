package faang.school.godbless.triWizardTournament;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");
        hogwarts.getTeam().add(new Student("Harry", 0,hogwarts));
        hogwarts.getTeam().add(new Student("Germiona", 0,hogwarts));
        hogwarts.getTeam().add(new Student("Ron", 0,hogwarts));
        beauxbatons.getTeam().add(new Student("Pat", 0,beauxbatons));
        beauxbatons.getTeam().add(new Student("Wiz", 0,beauxbatons));
        beauxbatons.getTeam().add(new Student("Mon", 0,beauxbatons));
        Task task1 = new Task("Jump",1,15);
        Task task2 = new Task("Fly",2,25);

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