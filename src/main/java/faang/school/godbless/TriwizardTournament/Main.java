package faang.school.godbless.TriwizardTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School school1 = new School("Хогвартс", List.of(
                new Student("AAA", 4, 0),
                new Student("BBB", 3, 0),
                new Student("CCC", 4, 0)));
        School school2 = new School("МБОУ СОШ № 15", List.of(
                new Student("ххх", 11, 0),
                new Student("ъъъ", 7, 0),
                new Student("щщщ", 9, 0)));

        Task task1 = new Task("Walk", 10, 300);
        Task task2 = new Task("Run", 15, 270);

        CompletableFuture<School> result1 = tournament.startTask(school1, task1);
        CompletableFuture<School> result2 = tournament.startTask(school2, task2);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(result1, result2);
        allTask.thenRun(() -> {
            if (school1.getTotalPoints() > school2.getTotalPoints()) {
                System.out.println("Winner " + school1);
            } else {
                System.out.println("Winner " + school2);
            }
        }).join();
    }
}
