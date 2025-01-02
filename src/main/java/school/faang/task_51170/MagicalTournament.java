package school.faang.task_51170;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        final List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));

        final List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        System.out.println(hogwarts.getName() + " wins the tournament with total points: "
                                + hogwarts.getTotalPoints() + " and " + beauxbatons.getName() + " had no chances");
                    } else if (hogwarts.getTotalPoints() < beauxbatons.getTotalPoints()) {
                        System.out.println(beauxbatons.getName() + " wins the tournament with total points: "
                                + beauxbatons.getTotalPoints() + " and " + hogwarts.getName() + " had no chances");
                    } else {
                        System.out.println("drawn game");
                    }
                }).join();
    }
}