package school.faang.task_50727;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        // Запуск заданий для школ
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    try {
                        tournament.shutdownExecutor();
                        School updatedHogwarts = hogwartsTask.get(); // Получаем обновленные данные
                        School updatedBeauxbatons = beauxbatonsTask.get();

                        if (updatedHogwarts.getTotalPoints() > updatedBeauxbatons.getTotalPoints()) {
                            System.out.println(updatedHogwarts.getName() + " wins the tournament!");
                        } else {
                            System.out.println(updatedBeauxbatons.getName() + " wins the tournament!");
                        }
                    } catch (Exception e) {
                        e.printStackTrace(); // Обработать исключения
                    }
                });

    }
}
