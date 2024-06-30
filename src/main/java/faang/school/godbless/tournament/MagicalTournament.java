package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) throws InterruptedException {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        List<Student> studentListOne = List.of(
                new Student("Ali",2002,150),
                new Student("John",2002,150)
        );
        List<Student> studentListTwo = List.of(
                new Student("Alex",2003,150),
                new Student("David",2004,150),
                new Student("Micheal",2004,250)
        );
        School hogwarts = new School("hogwarts",studentListOne);
        School beauxbatons = new School("beauxbatons",studentListTwo);
        Task task1 = new Task("Do first",3,1);
        Task task2 = new Task("Do first",3,1);
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
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
