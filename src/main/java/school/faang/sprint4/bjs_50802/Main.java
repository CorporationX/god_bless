package school.faang.sprint4.bjs_50802;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ConcurrentHashMap<School, Task> magicTournament = new ConcurrentHashMap<>();
        for (int i = 0; i < schools.size(); i++) {
            magicTournament.put(schools.get(i), tasks.get(i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<CompletableFuture<School>> startTournament = magicTournament.entrySet().stream()
                .map(entry -> tournament.startTask(entry.getKey(), entry.getValue(), executor))
                .toList();

        CompletableFuture<School> maxPointsSchool = CompletableFuture.allOf(
                        startTournament.toArray(new CompletableFuture[0]))
                .thenApply(schl -> startTournament.stream()
                        .map(CompletableFuture::join)
                        .max(Comparator.comparingInt(School::getTotalPoints))
                        .orElse(null));
        executor.shutdown();

        maxPointsSchool.thenAccept(winSchool -> {
            if (winSchool != null) {
                log.info("Winner: {} school with max points: {}", winSchool.name(), winSchool.getTotalPoints());
            } else {
                log.info("Wrong data");
            }
        });
    }
}
