package faang.school.godbless.BJS2_24737;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = List.of(new Student("Germiona", 2018),
                new Student("Harry", 2020),
                new Student("Ron", 2020));

        List<Student> beauxbatonsStudents = List.of(new Student("Chel", 2018),
                new Student("Vtoroy chel", 2020),
                new Student("Tretiy chel", 2020));

        School hogwarts = new School("Hogwarts", hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);

        Task task1 = new Task("Do a flip", 6, 250);
        Task task2 = new Task("Magic tricks", 8, 350);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        tournament.shutdown();

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.name() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.name() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

}
