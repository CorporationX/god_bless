package school.faang.bjs2_74964;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
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

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    School winner = Stream.of(hogwartsTask.join(), beauxbatonsTask.join())
                            .max(Comparator.comparingInt(School::getTotalPoints))
                            .orElseThrow(() -> new IllegalArgumentException("Cannot calculate the winner"));
                    log.info("The winner is {} school with {} points", winner.name(), winner.getTotalPoints());
                })
                .join();
        tournament.dispose();
    }
}