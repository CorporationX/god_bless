package school.faang.multithreading.tournamentOfWizards;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        List<Student> witchcraftRecipesTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        School witchcraftRecipes = new School("WitchcraftRecipes", witchcraftRecipesTeam);
        List<School> schools = List.of(hogwarts, beauxbatons, witchcraftRecipes);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task3 = new Task("Quidditch", 5, 150);

        ExecutorService executor = Executors.newFixedThreadPool(schools.size());

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1, executor);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2, executor);
        CompletableFuture<School> witchcraftRecipesTask = tournament.startTask(witchcraftRecipes, task3, executor);

        executor.shutdown();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, witchcraftRecipesTask)
                .thenRun(() -> {
                    Optional<School> winningSchool = schools.stream()
                            .max(Comparator.comparing(School::getTotalPoints));
                    winningSchool.ifPresent(school -> System.out.println("School: " + school.getName() + " won tournament!"));
                });
    }
}
