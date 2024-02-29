package faang.school.godbless.magicians;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        // Adding students to the list
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("John", 2, 85));
        students1.add(new Student("Alice", 3, 92));
        students1.add(new Student("Bob", 1, 78));

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("Emily", 4, 95));
        students2.add(new Student("David", 2, 88));
        students2.add(new Student("Sophia", 3, 90));

        School hogwarts = new School("Hogwarts", students1);
        School beauxbatons = new School("BeauxbatonsTask", students2);

        Task task1 = new Task("Task number 1", 100, 1000);
        Task task2 = new Task("Task number 2", 100, 1000);

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
