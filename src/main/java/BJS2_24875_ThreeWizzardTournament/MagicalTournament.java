package BJS2_24875_ThreeWizzardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<Student> hogwartsTeam = Arrays.asList(new Student("Harry Potter", 4),
                new Student("Percy Weasley", 3),
                new Student("Cedric Diggory", 6),
                new Student("Hermione Granger", 5));
        List<Student> beauxbatonsTeam = Arrays.asList(new Student("Fleur Delacour", 4),
                new Student("Emmanuel Macron", 7),
                new Student("Obelix", 2),
                new Student("Asterix", 6));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Take dragon egg", 5, 100);
        Task task2 = new Task("Go through labyrinth", 6, 120);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                log.info("The winner of the magical tournament is {} with {} points",
                        hogwarts.getName(), hogwarts.getTotalPoints());
                log.info("Congratulations!");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                log.info("The winner of the magical tournament is {} with {} points",
                        beauxbatons.getName(), beauxbatons.getTotalPoints());
                log.info("Congratulations!");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
