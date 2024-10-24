package school.faang.BJS2_39032;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<School> leaderboard = new ArrayList<>();

        List<Student> gryffindorTeam = List.of(
                new Student("Harry", 13, 0),
                new Student("Hermione", 11, 0),
                new Student("Angus", 14, 0)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 13, 0),
                new Student("Gabrielle", 12, 0),
                new Student("Noname", 8, 0)
        );
        List<Student> hufflepuffTeam = List.of(
                new Student("Anthony", 12, 0),
                new Student("Laura", 11, 0),
                new Student("Leanne", 13, 0)
        );

        School gryffindor = new School("Gryffindor", gryffindorTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        School hufflepuff = new School("Hufflepuff", hufflepuffTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task3 = new Task("A deadly swim", 9, 87);
        Task task4 = new Task("Flight of the Phoenix", 6, 66);

        CompletableFuture<School> gryffindorTask = tournament.startTask(gryffindor, task1);
        CompletableFuture<School> hufflepuffTask = tournament.startTask(hufflepuff, task4);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        beauxbatonsTask = tournament.startTask(beauxbatons, task3);


        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                gryffindorTask,
                beauxbatonsTask,
                hufflepuffTask
        );

        allTasks.thenRun(() -> {
            leaderboard.add()
        });
    }
}
