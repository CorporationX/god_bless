package faang.school.godbless.MagiciansTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        List<CompletableFuture<Void>> futureTasks = new ArrayList<>();
        List<CompletableFuture<School>> schoolCompletableFuture = new ArrayList<>();
        for (Student student : school.getTeam()) {
            CompletableFuture<Void> taskProceeding = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                student.setPoints(student.getPoints() + task.getReward());
            });
            futureTasks.add(taskProceeding);
        }
        return CompletableFuture.allOf(futureTasks.toArray(new CompletableFuture[0]))
                .thenApply(v -> school);
    }

    public static void main(String[] args) {
        School hogwarts = new School("Hogwarts School of Witchcraft and Wizardry", List.of(
                new Student("Harry Potter", 5, 0),
                new Student("Ron Weasley", 5, 0),
                new Student("Hermione Granger", 5, 0),
                new Student("Neville Longbottom", 5, 0),
                new Student("Luna Lovegood", 5, 0)
        ));
        School beauxbatons = new School("Beauxbatons Academy of Magic", List.of(
                new Student("Fleur Delacour", 6, 0),
                new Student("Roger Davies", 6, 0),
                new Student("Gabrielle Delacour", 6, 0)
        ));
        School durmstrang = new School("Durmstrang Institute", List.of(
                new Student("Viktor Krum", 7, 0),
                new Student("Igor Karkaroff", 7, 0)
        ));
        Task dragonBreath = new Task("Dragon's Breath", 8, 50);
        Task merpeopleSong = new Task("Merpeople's Song", 6, 30);
        Task mazeOfReflections = new Task("Maze of Reflections", 7, 40);
        Task wizardsDuel = new Task("Wizard's Duel", 9, 60);
        Task treasureHunt = new Task("Treasure Hunt", 5, 20);
        Tournament tournamentOfFire = new Tournament();
        CompletableFuture<School> resultOfHogwarts = tournamentOfFire.startTask(hogwarts, dragonBreath);
        CompletableFuture<School> resultOfDurmstrang = tournamentOfFire.startTask(durmstrang, dragonBreath);
        CompletableFuture<School> resultOfBeauxbatons = tournamentOfFire.startTask(beauxbatons, dragonBreath);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(resultOfDurmstrang, resultOfHogwarts, resultOfBeauxbatons);
        allTasks.thenRun(() -> {
            if (durmstrang.getTotalPoints() > hogwarts.getTotalPoints() && durmstrang.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + durmstrang.getName() + " with " + durmstrang.getTotalPoints() + " points.");
            } else if (hogwarts.getTotalPoints() > durmstrang.getTotalPoints() && hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints() && beauxbatons.getTotalPoints() > durmstrang.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("TIE!");
            }
        }).join();
    }
}
