package derschrank.sprint04.task03.bjstwo_51033;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        List<School> schools = List.of(hogwarts, beauxbatons);

        System.out.println("Summary Begin:");
        schools.forEach(System.out::println);


        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);


        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();
        System.out.println("Tournament was ended");

        CompletableFuture
                .supplyAsync(
                        () -> schools.stream()
                                .map(School::getTotalPoints)
                                .max(Integer::compareTo).get()
                )
                .thenCompose(result -> CompletableFuture.supplyAsync(
                        () -> schools.stream()
                                .filter(school -> school.getTotalPoints() >= result)
                                .map(School::name).toList()
                ))
                .thenAccept(
                        winners -> System.out.println(winners + " wins/win the tournament!!!\n")
                )
                .join();

        System.out.println("Summary Begin:");
        schools.forEach(System.out::println);
    }
}
