package faang.school.godbless.BJS2_25120;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = List.of(
                new Student("Гарри Поттер", 5),
                new Student("Гермиона Грейнджер", 5),
                new Student("Рон Уизли", 5)
        );

        List<Student> beauxbatonsStudents = List.of(
                new Student("Флер Делакур", 6),
                new Student("Клер Депампур", 6),
                new Student("Шлер Борматур", 6)
        );

        School hogwarts = new School("Hogwarts");
        hogwartsStudents.forEach(hogwarts::addStudent);

        School beauxbatons = new School("Beauxbatons");
        beauxbatonsStudents.forEach(beauxbatons::addStudent);

        Task task1 = new Task("Победи дракона", 3, 10);
        Task task2 = new Task("Забери золотое яйцо", 2, 8);

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
