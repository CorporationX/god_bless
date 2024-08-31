package faang.school.godbless.sprint4.triwizardTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class MagicalTournament {
    private static final int QUANTITY_OF_STUDENTS = 120;
    private static final int QUANTITY_OF_SCHOOLS = 3;
    private static List<School> schools;
    private static List<CompletableFuture<School>> tasks;
    private static Tournament tournament;

    public static void main(String[] args) {
        tournament = new Tournament();
        createTasksAndSchools();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        printResultsOfTournament(allTasks);
    }

    private static void createTasksAndSchools() {
        School hogwarts = new School("Hogwarts", buildStudentsForSchool(1));
        School beauxbatons = new School("Beauxbatons", buildStudentsForSchool(2));
        School durmstrang = new School("Durmstrang", buildStudentsForSchool(3));
        schools = new ArrayList<>(List.of(hogwarts, beauxbatons, durmstrang));
        Task task1 = new Task("Task 1", 1, 20);
        Task task2 = new Task("Task 2", 1, 25);
        Task task3 = new Task("Task 3", 1, 23);
        Task task4 = new Task("Task 4", 2, 15);
        Task task5 = new Task("Task 5", 2, 20);
        Task task6 = new Task("Task 6", 2, 21);
        tasks = List.of(
                tournament.startTask(hogwarts, task1),
                tournament.startTask(beauxbatons, task2),
                tournament.startTask(durmstrang, task3),
                tournament.startTask(hogwarts, task4),
                tournament.startTask(beauxbatons, task5),
                tournament.startTask(durmstrang, task6));
    }

    private static void printResultsOfTournament(CompletableFuture<Void> allTasks) {
        allTasks.thenRun(() -> {
            List<School> winners = winner();
            if (winners.size() == 1) {
                School winner = winners.get(0);
                System.out.println("The winner of the magical tournament is " + winner + " with " + winner.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie between schools: " + winners);
            }
        }).join();
    }

    private static List<School> winner() {
        int maxPoints = schools.stream()
                .mapToInt(School::getTotalPoints)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        return schools.stream()
                .filter(school -> school.getTotalPoints() == maxPoints)
                .toList();
    }

    private static List<Student> buildStudentsForSchool(int index) {
        int quantityAtSchool = QUANTITY_OF_STUDENTS / QUANTITY_OF_SCHOOLS;
        int begin = quantityAtSchool * index - quantityAtSchool + 1;
        int end = quantityAtSchool * index;
        return IntStream
                .rangeClosed(begin, end)
                .mapToObj(number -> new Student(String.format("Student %s", number)))
                .toList();
    }
}
