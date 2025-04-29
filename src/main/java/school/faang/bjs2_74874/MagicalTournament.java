package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        List<School> schools = List.of(hogwarts, beauxbatons);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task1);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                hogwartsTask1,
                hogwartsTask2,
                beauxbatonsTask1,
                beauxbatonsTask2);

        allTasks.join();

        List<School> winSchools = getWinningSchools(schools);

        winSchools.forEach(winSchool -> log.info("Winning school {}", winSchool.name()));

        tournament.poolShutdown();
    }

    private static List<School> getWinningSchools(List<School> schools) {
        int maxPoints = schools.stream()
                .mapToInt(School::getTotalPoints)
                .max()
                .orElseThrow(SchoolNotFoundException::new);

        return schools.stream()
                .filter(school -> Objects.equals(school.getTotalPoints(), maxPoints))
                .toList();
    }
}
