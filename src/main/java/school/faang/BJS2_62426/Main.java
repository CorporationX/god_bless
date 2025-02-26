package school.faang.BJS2_62426;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

        CompletableFuture<Void> result = CompletableFuture
                .allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    School hogwartsSchool = hogwartsTask.join();
                    School beauxbatonsSchool = beauxbatonsTask.join();
                    System.out.println(hogwartsSchool);
                    System.out.println(beauxbatonsSchool);

                    if (hogwartsSchool.getTotalPoints() > beauxbatonsSchool.getTotalPoints()) {
                        System.out.printf("Выиграла школа %s набрав %d очков",
                                hogwartsSchool.getName(), hogwartsSchool.getTotalPoints());
                    } else {
                        System.out.printf("Выиграла школа %s набрав %d очков",
                                beauxbatonsSchool.getName(), beauxbatonsSchool.getTotalPoints());
                    }
                });
        result.join();
    }
}
