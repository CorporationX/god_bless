package bjs2_92887;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        Random random = new Random();

        Map<String, School> schools = Map.of(
                "hogwarts", new School("Хогвартс", new ArrayList<>(List.of(
                        new Student("Гарри", 5, 0),
                        new Student("Гермиона", 5, 0)
                ))),
                "beauxbatons", new School("Бобатон", new ArrayList<>(List.of(
                        new Student("Флёр", 6, 0),
                        new Student("Габриэль", 6, 0)
                ))),
                "durmstrang", new School("Дурмстранг", new ArrayList<>(List.of(
                        new Student("Виктор", 6, 0),
                        new Student("Игорь", 7, 0)
                )))
        );

        Map<String, Task> tasks = Map.of(
                "triwizard", new Task("Турнир Трёх Волшебников", 3, 100),
                "yule", new Task("Подготовка к балу", 2, 50),
                "dragon", new Task("Сражение с драконом", 4, 120)
        );

        List<CompletableFuture<School>> futures = schools.values().stream()
                .map(school -> {
                    Task randomTask = tasks.values()
                            .stream()
                            .skip(random.nextInt(tasks.size()))
                            .findFirst()
                            .orElseThrow();

                    return tournament.startTask(school, randomTask);
                })
                .toList();


        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        all.thenRun(() -> {
            System.out.println("\n=== Итоги турнира ===");
            schools.values().forEach(school -> {
                System.out.printf("%s: %d очков%n", school.getName(), school.getTotalPoints());
                school.getTeam().forEach(student ->
                        System.out.printf("   %s (год %d): %d очков%n",
                                student.getName(), student.getYear(), student.getPoints()));
            });

            int maxPoints = schools.values().stream()
                    .mapToInt(School::getTotalPoints)
                    .max()
                    .orElse(0);

            List<School> winners = schools.values().stream()
                    .filter(s -> s.getTotalPoints() == maxPoints)
                    .toList();

            if (winners.size() > 1) {
                String names = winners.stream()
                        .map(School::getName)
                        .collect(Collectors.joining(", "));
                System.out.printf("Ничья между: %s%n", names);
            } else if (!winners.isEmpty()) {
                System.out.printf("\nПОБЕДИТЕЛЬ: %s%n", winners.get(0).getName());
            } else {
                System.out.println("Нет результатов.");
            }
        }).join();
    }
}