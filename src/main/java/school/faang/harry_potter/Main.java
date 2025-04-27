package school.faang.harry_potter;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        // Запуск заданий для школ
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        List<CompletableFuture<School>> futures = List.of(hogwartsTask, beauxbatonsTask);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        printResultTournament(futures);
        tournament.shutdown();
    }

    public static void printResultTournament(List<CompletableFuture<School>> futures) {
        List<School> schools = futures.stream()
                .map(CompletableFuture::join)
                .toList();
        School winner = schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElseThrow();
        schools.forEach(school -> log.info("Школа {}: {}",
                school.getName(),
                school.getTotalPoints()));
        log.info("Победитель: {} - {}",
                winner.getName(),
                winner.getTotalPoints());
    }
}
