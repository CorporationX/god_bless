package school.faang.task50717;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        List<School> schools = List.of(
                new School("Hogwarts", hogwartsTeam),
                new School("Beauxbatons", beauxbatonsTeam)
        );

        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", Difficulty.HIGH, 100),
                new Task("Yule Ball Preparations", Difficulty.MIDDLE, 50)
        );

        List<CompletableFuture<School>> completableFutures = new ArrayList<>();

        IntStream.range(0, tasks.size()).forEach(i -> {
            School school = schools.get(i);
            Task task = tasks.get(i);
            completableFutures.add(tournament.startTask(school, task));
        });

        CompletableFuture<Void> all = CompletableFuture
                .allOf(completableFutures.toArray(CompletableFuture[]::new));

        all.thenRun(() -> {
            School school = schools.stream().max((school1, school2) -> Integer.compare(school2.getTotalPoints(),
                    school1.getTotalPoints())).get();
            log.info("Школа {} набрала больше всех баллов: {}", school.name(), school.getTotalPoints());
        });

        all.join();
    }
}
