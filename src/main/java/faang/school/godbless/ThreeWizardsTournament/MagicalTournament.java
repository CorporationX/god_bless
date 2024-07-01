package faang.school.godbless.ThreeWizardsTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> studentsOfHogwarts = getStudentsOfHogwarts();
        List<Student> studentsOfBeauxbatons = getStudentsOfBeauxbatons();
        School hogwarts = new School("Hogwarts", studentsOfHogwarts);
        School beauxbatons = new School("Beauxbatons", studentsOfBeauxbatons);

        Task task1 = new Task("Hard Task", 5, 10);
        Task task2 = new Task("Light task", 2, 5);

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        // Обработка результатов заданий
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

        Tournament.shutdownTournament();
    }

    public static List<Student> getStudentsOfHogwarts() {
        return List.of(
                new Student("Garry Potter", 1, 0),
                new Student("Germiona Grandger", 1, 0),
                new Student("Drako Malfoy", 1, 0)
        );
    }

    public static List<Student> getStudentsOfBeauxbatons() {
        return List.of(
                new Student("Drako Malfoy", 1, 0)
        );
    }
}

