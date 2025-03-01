package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        List<CompletableFuture<School>> features = new ArrayList<>();

        Task firstTask = new Task("Triwizard Tournament", 10, 100);
        Task secondTask = new Task("Yule Ball Preparations", 5, 50);

        features.add(tournament.startTask(hogwarts, firstTask));
        features.add(tournament.startTask(beauxbatons, secondTask));
        CompletableFuture.allOf(features.toArray(new CompletableFuture[0])).join();

        calculateResults(features).ifPresent(school -> {
            log.info("{} победила набрав {} очков", school.name(), school.getTotalPoints());
        });
    }

    private static Optional<School> calculateResults(List<CompletableFuture<School>> futures) {
        return futures.stream()
                .map(CompletableFuture::join)
                .max(Comparator.comparingDouble(School::getTotalPoints));
    }
}
