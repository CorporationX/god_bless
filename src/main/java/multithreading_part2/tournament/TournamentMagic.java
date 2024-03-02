package multithreading_part2.tournament;

import java.util.concurrent.CompletableFuture;

public class TournamentMagic {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("Hogwarts");
        Student sam = new Student("Sam", 1998, 0);
        Student artem = new Student("Artem", 1997, 0);
        hogwarts.addStudents(sam);
        hogwarts.addStudents(artem);

        School gbousosh2063 = new School("GBOUSOSH2063");
        Student anna = new Student("Anna", 1998, 0);
        Student kate = new Student("Kate", 1996, 0);
        gbousosh2063.addStudents(anna);
        gbousosh2063.addStudents(kate);

        Task superman = new Task("superman", 1000, 100);
        Task mikeMouse = new Task("mikeMouse", 800, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, superman);
        CompletableFuture<School> gbousosh2063Task = tournament.startTask(gbousosh2063, mikeMouse);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, gbousosh2063Task);

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > gbousosh2063.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (gbousosh2063.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + gbousosh2063.getName() + " with " + gbousosh2063.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();

    }
}
