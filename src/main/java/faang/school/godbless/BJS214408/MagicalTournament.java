package faang.school.godbless.BJS214408;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MagicalTournament {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tournament tournament = new Tournament();
        School hogwarts  = new School("hogwarts", List.of(
                new Student("Student1", 13, 0),
                new Student("Student2", 12, 0),
                new Student("Student3", 11, 0)));
        School beauxbatons  = new School("beauxbatons", List.of(
                new Student("Student1", 14, 0),
                new Student("Student2", 75, 0),
                new Student("Student3", 5, 0),
                new Student("Student4", 15, 0)));

        Task task1 = new Task("Walk", 10, 300);
        Task task2 = new Task("Run", 15, 270);

        CompletableFuture<School> school1Task = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> school2Task = tournament.startTask(beauxbatons , task2);
        Tournament.EXECUTOR_SERVICE.shutdown();

        School winner = school1Task.thenCombine(school2Task, MagicalTournament::getWinner).get();

        System.out.println("The winner of the magical tournament is " + winner.getName() + " with " + winner.getTotalPoints() + " points.");
    }

    private static School getWinner(School s1, School s2) {
        return s1.getTotalPoints() > s2.getTotalPoints() ? s1 : s2;
    }

}