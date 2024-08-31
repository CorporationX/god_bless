package faang.school.godbless.sprint4.wizard;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts", List.of(
                new Student("Harry Potter", 4),
                new Student("Sedrick Diggory", 7)
        ));
        School durmstrang = new School("Durmstrang", List.of(
                new Student("Victor Krum", 7)
        ));
        School beauxbatons = new School("Beauxbatons", List.of(
                new Student("Fleur DeLacour", 7)
        ));

        Task t1 = new Task("Fight the dragon", 1, "Golden Egg".length());
        Task t2 = new Task("Long lake dive", 2, "Save your friends".length());
        Task t3 = new Task("Escape the maze", 3, "Earn the wizard cup".length());

        Stream.of(t1, t2, t3).forEach(t ->
                CompletableFuture.allOf(
                    tournament.startTask(t, hogwarts),
                    tournament.startTask(t, beauxbatons),
                    tournament.startTask(t, durmstrang)
                )
                .thenRun(() -> System.out.printf("Trial '%s' is over!%n", t.name()))
                .join()
        );

        School winner = Stream.of(hogwarts, beauxbatons, durmstrang)
                .max(Comparator.comparing(School::getTotalPoints))
                .orElseThrow();
        Stream.of(hogwarts, beauxbatons, durmstrang)
                .forEach(s -> System.out.println("School: " + s.getName() + " (points " + s.getTotalPoints() + ")"));

        System.out.printf("Winning school: %s (total points - %d)", winner.getName(), winner.getTotalPoints());
    }
}
