package school.faang.threewizards;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class Application {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Tournament tournament = new Tournament(executor);

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );

        List<SchoolAssignment> schoolAssignments = List.of(
                new SchoolAssignment(new School("Hogwarts", hogwartsTeam), new Task("Triwizard Tournament", 7, 100)),
                new SchoolAssignment(new School("Beauxbatons", beauxbatonsTeam), new Task("Yule Ball Preparations", 2, 50))
        );

        List<CompletableFuture<School>> tournamentResults = schoolAssignments.stream()
                .map(tournament::startTask).toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(tournamentResults.toArray(new CompletableFuture[0]));

        CompletableFuture<List<School>> allResults = allFutures.thenApply(v ->
                tournamentResults.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        );

        CompletableFuture<Optional<School>> maxPointsSchool = allResults.thenApply(result ->
                result.stream()
                        .max(Comparator.comparingInt(School::getTotalPoints))
        );

        maxPointsSchool.join().ifPresentOrElse(
                school -> log.info("Winner: {}", school),
                () -> log.info("Error !!!"));

        executor.shutdown();
    }
}
