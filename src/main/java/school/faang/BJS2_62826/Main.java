package school.faang.BJS2_62826;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
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

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    try {
                        School hogwartsResult = hogwartsTask.get();
                        School beauxbatonsResult = beauxbatonsTask.get();

                        int hogwartsPoints = hogwartsResult.getTotalPoints();
                        int beauxbatonsPoints = beauxbatonsResult.getTotalPoints();

                        System.out.println("🏆 Очки школ:");
                        System.out.println(hogwartsResult.getName() + ": " + hogwartsPoints);
                        System.out.println(beauxbatonsResult.getName() + ": " + beauxbatonsPoints);

                        if (hogwartsPoints > beauxbatonsPoints) {
                            System.out.println("🎉 Победитель: " + hogwartsResult.getName() + "!");
                        } else if (beauxbatonsPoints > hogwartsPoints) {
                            System.out.println("🎉 Победитель: " + beauxbatonsResult.getName() + "!");
                        } else {
                            System.out.println("🤝 Ничья!");
                        }
                    } catch (Exception e) {
                        log.error("Подсчет очков не завершен", e);
                    }

                }).join();
    }
}
