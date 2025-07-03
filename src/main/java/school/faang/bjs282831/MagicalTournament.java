package school.faang.bjs282831;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        final Tournament tournament = new Tournament();

        log.info("🪄 Добро пожаловать в Магический Турнир! 🪄");

        List<Student> hogwartsTeam = List.of(
                new Student("Harry Potter", 5, 0),
                new Student("Hermione Granger", 5, 0),
                new Student("Ron Weasley", 5, 0)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur Delacour", 6, 0),
                new Student("Gabrielle Delacour", 4, 0)
        );

        List<Student> durmstrangTeam = List.of(
                new Student("Viktor Krum", 6, 0),
                new Student("Poliakoff", 5, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        School durmstrang = new School("Durmstrang", durmstrangTeam);

        List<School> schools = List.of(hogwarts, beauxbatons, durmstrang);

        final Task task1 = new Task("Triwizard Tournament - Dragon Challenge", 10, 100);
        final Task task2 = new Task("Yule Ball Preparations", 5, 50);
        final Task task3 = new Task("Underwater Rescue Mission", 8, 80);

        log.info("🎭 Школы и команды зарегистрированы!");
        schools.forEach(school -> {
            log.info("🏫 {}: {} студентов", school.getName(), school.getTeam().size());
        });

        log.info("🚀 Запуск заданий турнира...");

        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask2 = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> durmstrangTask3 = tournament.startTask(durmstrang, task3);

        CompletableFuture<School> hogwartsTask2 = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task1);
        CompletableFuture<School> durmstrangTask2 = tournament.startTask(durmstrang, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                hogwartsTask1, beauxbatonsTask2, durmstrangTask3,
                hogwartsTask2, beauxbatonsTask1, durmstrangTask2
        );

        allTasks.thenRun(() -> {
            log.info("✅ Все задания выполнены!");
            tournament.displayResults(schools);
        }).join();

        log.info("🏁 Турнир завершён! Увидимся в следующем году! 🏁");
    }
}