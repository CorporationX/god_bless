package faang.school.godbless.Sprint4Future.ThreeWizardsTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)
        List<Student> hogwartsStudents = List.of(new Student("Germiona", 12,500)
                ,new Student("Garri",12,0));
        List<Student> beauxbatonsStudents = List.of(new Student("Peter", 12,200)
                ,new Student("Luis",12,0));
        School hogwarts = new School("Hogwarts",hogwartsStudents);
        School beauxbatons = new School("Beauxbatons", beauxbatonsStudents);
        Task task1 = new Task("Find magic something",100,300);
        Task task2 = new Task("Kill Volandemort",3000,1000);

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
    }
}
