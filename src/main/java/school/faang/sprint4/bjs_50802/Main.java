package school.faang.sprint4.bjs_50802;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        List<School> schools = List.of(
                new School("Hogwarts", hogwartsTeam),
                new School("Beauxbatons", beauxbatonsTeam));
        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", 10, 130),
                new Task("Yule Ball Preparations", 5, 50));

        Tournament tournament = new Tournament();
        List<CompletableFuture<School>> startTournaments = new ArrayList<>();
        for (int i = 0; i < schools.size(); i++) {
            startTournaments.add(tournament.startTask(schools.get(i), tasks.get(i)));
        }

        CompletableFuture<Void> allTournaments = CompletableFuture.allOf(
                startTournaments.toArray(new CompletableFuture[0]));
        allTournaments.join();

        Optional<School> winSchool = schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints));

        log.info("Winner: {} school with max points: {}", winSchool.get().name(), winSchool.get().getTotalPoints());

    }
}
