package school.faang.bjs2_92858;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Хогвартс", Arrays.asList(
                new Student("Гарри Поттер", 5),
                new Student("Рон Уизли", 5),
                new Student("Гермиона Грейнджер", 5)));

        School stardustCrusaders = new School("Рыцыри Звёздной Пыли", Arrays.asList(
                new Student("Джотаро Куджо", 5),
                new Student("Какеин Нориаки", 5),
                new Student("Джозеф Джостар", 5),
                new Student("Мохаммед Абдул", 5),
                new Student("Жан Пьер Польнарефф", 5)));

        Task task1 = new Task("Квидич со Слизерином", 3, 158);
        Task task2 = new Task("Убить Дио и вернуться в Японию", 10, 1000);

        CompletableFuture<School> hogwartsTask = tournament.startQuest(hogwarts, task1);
        CompletableFuture<School> crusadersTask = tournament.startQuest(stardustCrusaders, task2);
        tournament.executorService.shutdown();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, crusadersTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > stardustCrusaders.getTotalPoints()) {
                System.out.printf(
                        "Хогвартс побеждает! %d > %d",
                        hogwarts.getTotalPoints(),
                        stardustCrusaders.getTotalPoints()
                );
            } else {
                System.out.printf("Стардасты побеждают! %d > %d",
                        stardustCrusaders.getTotalPoints(),
                        hogwarts.getTotalPoints()
                );
            }
        });
    }
}