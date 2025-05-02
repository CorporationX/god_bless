package school.faang.three_warlock_tournament;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();

        List<School> schoolList = List.of(hogwarts, beauxbatons);
        School winner = schoolList.stream()
                .max(Comparator.comparingInt(School::getTotalPoints)).orElseThrow();


        System.out.println("Counting points..."); // simulate a counting process
        CompletableFuture
                .runAsync(() -> {}, CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS))
                .join();

        System.out.println("\n The winner is: " + winner.getName() +
                " : " + winner.getTotalPoints() + " points!");

        for (School school : schoolList) {
            System.out.println(school.getName() + ": " + school.getTotalPoints() + " points");
            for (Student s : school.getTeam()) {
                System.out.println("   - " + s.getName() + ": " + s.getPoints());
            }
        }
    }
}
