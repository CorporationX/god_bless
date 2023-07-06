package faang.school.godbless.triwizard.tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> studentsHogwarts = List.of(
                new Student("Ser", 5, 11),
                new Student("Iva", 12, 3),
                new Student("Lua", 44, 1)
        );
        School hogwarts = new School("Hogwarts", studentsHogwarts);
        List<Student> studentsBeauxbatons = List.of(
                new Student("Ghg", 8, 8),
                new Student("Uta", 1, 77),
                new Student("Qas", 23, 25)
        );
        School beauxbatons = new School("Beauxbatons", studentsBeauxbatons);

        Task task1 = new Task("sss", 5, 7);
        Task task2 = new Task("QQQ", 2, 4);

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
