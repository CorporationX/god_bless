package faang.school.godbless.TriwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        List<Student> hogwartsStudents = Arrays.asList(
                new Student("Harry", 4, 0),
                new Student("Hermione", 4, 0),
                new Student("Ron", 4, 0)
        );
        List<Student> beauxbatonsStudents = Arrays.asList(
                new Student("Fleur", 5, 0),
                new Student("Gabrielle", 3, 0),
                new Student("Jean", 4, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);

        Task task1 = new Task("Dragon Challenge", 2, 100);
        Task task2 = new Task("Maze Challenge", 3, 150);

        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            long hogwartsPoints = hogwarts.getTotalPoints();
            long beauxbatonsPoints = beauxbatons.getTotalPoints();

            if (hogwartsPoints > beauxbatonsPoints) {
                log.info("The winner of the magical tournament is {} with {} points.", hogwarts.getName(), hogwartsPoints);
            } else if (beauxbatonsPoints > hogwartsPoints) {
                log.info("The winner of the magical tournament is {} with {} points.", beauxbatons.getName(), beauxbatonsPoints);
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
