package faang.school.godbless.BJS2_24767;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        School hogwarts = new School("Hogwarts", List.of(new Student("Harry", 2000, 0),
                new Student("Ron", 1999, 0)
        ));
        Task task1 = new Task("Cast Ghost", 3, 300);

        School beauxbatons = new School("Beauxbatons", List.of(new Student("Aurelie", 2000, 0),
                new Student("Celine", 2002, 0)
        ));
        Task task2 = new Task("Cast Elepant", 4, 400);

        System.out.println("Star");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
