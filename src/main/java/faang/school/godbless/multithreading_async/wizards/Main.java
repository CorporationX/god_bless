package faang.school.godbless.multithreading_async.wizards;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов
        Student harry = new Student("Harry", 5);
        Student hermione = new Student("Hermione", 6);
        Student ron = new Student("Ron", 4);
        Student draco = new Student("Draco", 5);
        Student luna = new Student("Luna", 6);
        Student neville = new Student("Neville", 4);

        // Создание волшебных школ
        School hogwarts = new School("Hogwarts");
        School beauxbatons = new School("Beauxbatons");

        // Добавление студентов в школы
        hogwarts.addStudent(harry);
        hogwarts.addStudent(hermione);
        hogwarts.addStudent(ron);
        beauxbatons.addStudent(draco);
        beauxbatons.addStudent(luna);
        beauxbatons.addStudent(neville);

        // Создание заданий
        Task task1 = new Task("Task 1", 5, 10);
        Task task2 = new Task("Task 2", 8, 15);
        Task task3 = new Task("Task 3", 4, 8);
        Task task4 = new Task("Task 4", 6, 12);

        // Запуск заданий
        CompletableFuture<School> hogwartsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask1 = tournament.startTask(beauxbatons, task2);
        CompletableFuture<School> hogwartsTask2 = hogwartsTask1.thenCompose(result -> tournament.startTask(hogwarts, task4));
        CompletableFuture<School> beauxbatonsTask2 = beauxbatonsTask1.thenCompose(result -> tournament.startTask(beauxbatons, task3));

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask1, beauxbatonsTask1,
                hogwartsTask2, beauxbatonsTask2);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();

        tournament.shutdownExecutorService();
    }
}
