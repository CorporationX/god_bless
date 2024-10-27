package school.faang.BJS2_39032;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<School> schools = new ArrayList<>();
        Map<Integer, List<School>> leaderboard = new HashMap<>();

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

        schools.addAll(Arrays.asList(gryffindor, beauxbatons, hufflepuff));

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task3 = new Task("A deadly swim", 9, 50);
        Task task4 = new Task("Flight of the Phoenix", 6, 66);

        CompletableFuture<School> gryffindorTask = tournament.startTask(gryffindor, task1);
        CompletableFuture<School> hufflepuffTask = tournament.startTask(hufflepuff, task4);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        beauxbatonsTask = beauxbatonsTask.thenCompose(school -> tournament.startTask(beauxbatons, task3));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                gryffindorTask,
                beauxbatonsTask,
                hufflepuffTask
        );

        allTasks.thenRun(() -> {
            schools.forEach(school -> {
                leaderboard
                        .computeIfAbsent(school.getTotalPoints(), k -> new ArrayList<>())
                        .add(school);
            });

            int maxPoints = leaderboard.keySet().stream().max(Integer::compareTo).orElse(0);

            List<School> topSchools = leaderboard.get(maxPoints);
            if (topSchools != null) {
                System.out.print("Победитель: ");
                topSchools.forEach(school -> System.out.print(school.getName() + " "));
                System.out.println();
            }
        }).join();
        tournament.shutdown();
    }
}
