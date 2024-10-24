package bjs2_39009;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        School school1 = new School("school1",
                List.of(
                        new Student("student1", 3, 0),
                        new Student("student2", 2, 0),
                        new Student("student3", 2, 0)
                ));
        School school2 = new School("school2",
                List.of(
                        new Student("student4", 3, 0),
                        new Student("student5", 2, 0),
                        new Student("student6", 2, 0)
                ));
        Task task1 = new Task("task1", 300, 20);
        Task task2 = new Task("task2", 700, 12);

        Tournament tournament = new Tournament();
        CompletableFuture<School> future1 = tournament.startTask(school1, task1);
        CompletableFuture<School> future2 = tournament.startTask(school2, task2);

        CompletableFuture.allOf(future1, future2).thenRun(() -> {
            System.out.println("First school total points: " + school1.getTotalPoints());
            System.out.println("Second school total points: " + school2.getTotalPoints());
            System.out.println("Winner: " + (school1.getTotalPoints() > school2.getTotalPoints() ?
                    school1.getName() : school2.getName()));
        }).join();
    }
}
