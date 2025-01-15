package triwizard_tournament;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(beauxbatons, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(hogwarts, task2);

        CompletableFuture<Void> result = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenApply(var -> {
                    return Stream.of(hogwartsTask, beauxbatonsTask)
                            .map(CompletableFuture::join)
                            .max(Comparator.comparing(School::getTotalPoints))
                            .orElse(null);
                })
                .thenAccept(school -> {
                    if (school == null) {
                        System.out.println("Победителя нет!");
                    } else {
                        System.out.printf("Победителем стала школа: %s финальные очки %d", school.getName(), school.getTotalPoints());
                    }
                });

        tournament.executorService.shutdown();
    }
}
