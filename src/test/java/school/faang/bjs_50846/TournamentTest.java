package school.faang.bjs_50846;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class TournamentTest {

    @Test
    void startTask() {
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
        CompletableFuture<School> winnerTask = hogwartsTask.thenCombine(beauxbatonsTask, (s1, s2) ->
                s1.getTotalPoints() > s2.getTotalPoints() ? s1 : s2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, winnerTask);

        allTasks.join();
        Assertions.assertTrue(hogwartsTask.isDone());
        Assertions.assertTrue(beauxbatonsTask.isDone());
        Assertions.assertTrue(winnerTask.isDone());

        Assertions.assertEquals("Hogwarts", winnerTask.join().getName());
    }
}