package school.faang.sprint_4.task_50773;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TournamentTest {
    Tournament tournament = new Tournament();

    @Test
    void testStartTaskBaseCase() {
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
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = CompletableFuture.supplyAsync(
                () -> tournament.startTask(hogwarts, task1)
        );
        CompletableFuture<School> beauxbatonsTask = CompletableFuture.supplyAsync(
                () ->  tournament.startTask(beauxbatons, task2)
        );

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();

        Assertions.assertEquals(200, hogwarts.getTotalPoints());
        Assertions.assertEquals(100, beauxbatons.getTotalPoints());
    }
}
