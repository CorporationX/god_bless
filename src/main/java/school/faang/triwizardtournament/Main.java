package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try (Tournament tournament = new Tournament()) {
            // Создание школ
            List<Student> hogwartsTeam = List.of(
                    new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
            List<Student> beauxbatonsTeam = List.of(
                    new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
            School hogwarts = new School("Hogwarts", hogwartsTeam);
            School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

            // Создание заданий
            Task task1 = new Task("Triwizard Tournament", 10, 100);
            Task task2 = new Task("Yule Ball Preparations", 5, 50);

            // Запуск заданий для школ
            List<CompletableFuture<School>> allFutureTasks = List.of(
                    tournament.startTask(hogwarts, task1),
                    tournament.startTask(beauxbatons, task2)
            );
            CompletableFuture<Void> allTasks =
                    CompletableFuture.allOf(allFutureTasks.toArray(new CompletableFuture[0]));
            // Обработка результатов всех заданий и определение победителя
            allTasks.join();
            printResults(allFutureTasks.stream()
                    .map(CompletableFuture::join)
                    .toList());

        }
    }

    public static void printResults(List<School> schools) {
        School winner = schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElseThrow();
        int maxPoints = schools.stream()
                .mapToInt(School::getTotalPoints)
                .max()
                .orElseThrow();
        List<School> topScores = schools.stream()
                .filter(s -> s.getTotalPoints() == maxPoints)
                .toList();
        System.out.println("\n=== all schools results ===");
        schools.forEach(s -> System.out.printf("School %s - %d\n", s.name(), s.getTotalPoints()));

        if (topScores.size() == 1) {
            System.out.printf("\nWinner: %s\n", winner.name());
        } else {
            System.out.println("\nDraw between:");
            topScores.forEach(s -> System.out.printf("- %s (%d points)\n", s.name(), s.getTotalPoints()));
        }
    }
}


