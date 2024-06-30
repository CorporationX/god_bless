package faang.school.godbless.multithreading_2.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий
        School hogwarts = new School("Hogwarts", List.of(
                new Student("Гарри", 18, 10),
                new Student("Сэдрик", 20, 11),
                new Student("Рон", 18, 12)
        ));
        School beauxbatons = new School("Beauxbatons", List.of(
                new Student("Виктор", 18, 10),
                new Student("Макгонагл", 200, 11),
                new Student("Хагрид", 300, 12)
        ));

        Task task1 = new Task("Озеро", 2, 5);
        Task task2 = new Task("Драконы", 3, 7);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println(
                        "The winner of the magical tournament is " + hogwarts.name()
                                + " with " + hogwarts.getTotalPoints() + " points."
                );
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println(
                        "The winner of the magical tournament is " + beauxbatons.name()
                                + " with " + beauxbatons.getTotalPoints() + " points."
                );
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}