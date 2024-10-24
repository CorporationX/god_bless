package school.faang.wizardstournament;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MagicalTournament {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            System.out.println("School: " + hogwarts.getName() + "; Points: " + hogwarts.getTotalPoints());
            System.out.println("School: " + beauxbatons.getName() + "; Points: " + beauxbatons.getTotalPoints());
            findWinner(List.of(hogwarts, beauxbatons))
                    .ifPresentOrElse(s -> System.out.println("The Winner is " + s.getName() + "!!!"),
                            () -> System.out.println("No winner found"));
        }).join();
    }

    private static Optional<School> findWinner(List<School> schools) {
        return schools.stream().max(Comparator.comparing(School::getTotalPoints));
    }
}
