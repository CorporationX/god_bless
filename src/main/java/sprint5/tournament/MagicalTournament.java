package sprint5.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    private static final String WINNER_FORMAT = "The winner of the magical tournament is %s with %d points.\n";

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts", getStudentsOfHogwarts());
        School beauxbatons = new School("Beauxbatons", getStudentsOfBeauxbatons());

        Task task1 = new Task("Go through the maze", 6, 8);
        Task task2 = new Task("Get an artifact from the mermaids", 4, 5);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.printf(WINNER_FORMAT, hogwarts.name(), hogwarts.getTotalPoints());
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.printf(WINNER_FORMAT, beauxbatons.name(), beauxbatons.getTotalPoints());
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static List<Student> getStudentsOfHogwarts() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harry", 4));
        students.add(new Student("Ron", 4));
        students.add(new Student("Hermione", 4));
        students.add(new Student("Tina", 3));
        return students;
    }

    private static List<Student> getStudentsOfBeauxbatons() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Gabrielle", 3));
        students.add(new Student("Fleur", 4));
        students.add(new Student("Aurelie", 4));
        students.add(new Student("Celine", 3));
        return students;
    }
}
