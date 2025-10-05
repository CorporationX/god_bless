package school.faang.sprint4.school;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, new AtomicInteger(5)),
                new Student("Hermione", 5, new AtomicInteger(5)));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, new AtomicInteger(4)),
                new Student("Gabrielle", 6, new AtomicInteger(4)));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        Tournament tournament = new Tournament(List.of(hogwarts, beauxbatons));

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task1);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask1, beauxbatonsTask1, hogwartsTask2,
                beauxbatonsTask2);

        allTasks
                .thenRun(tournament::printResults)
                .thenRun(() -> System.out.printf("Winner is %s\n", tournament.getWinner().getName()))
                .join();

        tournament.end();
    }
}
