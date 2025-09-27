package school.faang.BJS2_92822;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        AtomicBoolean busy = new AtomicBoolean(false);
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, busy, 0),
                new Student("Hermione", 5, busy, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, busy, 0),
                new Student("Gabrielle", 6, busy, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task3 = new Task("broomstick flight", 7, 123);
        Task task4 = new Task("Hide and seek", 4, 20);
        Task task5 = new Task("defeat the dragon", 6, 200);
        Task task6 = new Task("go through the maze", 4, 290);
        List<Task> listTask = List.of(task1, task2, task3, task4, task5, task6);
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, listTask);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, listTask);

        hogwartsTask.join();
        beauxbatonsTask.join();

        hogwarts.getTotalPoints();
        beauxbatons.getTotalPoints();
    }
}
