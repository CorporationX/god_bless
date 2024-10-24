package school.faang.threewizardchallenge;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        // Обработка результатов всех заданий и определение победителя

        allTasks.thenRun(() -> {
            try {
                School completedHogwarts = hogwartsTask.get();
                School completedBeauxbatons = beauxbatonsTask.get();

                System.out.println(completedHogwarts.getName() + " total points: " + completedHogwarts.getTotalPoints());
                System.out.println(completedBeauxbatons.getName() + " total points: " + completedBeauxbatons.getTotalPoints());

                School winner = completedHogwarts.getTotalPoints() > completedBeauxbatons.getTotalPoints() ? completedHogwarts : completedBeauxbatons;
                System.out.println("The winner is: " + winner.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }
}
