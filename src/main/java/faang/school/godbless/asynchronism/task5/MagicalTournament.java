package faang.school.godbless.asynchronism.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsStudents = new ArrayList<>();
        hogwartsStudents.add(new Student("Гарри Поттер", 1, 100));
        hogwartsStudents.add(new Student("Гермиона Грейнджер", 1, 120));
        hogwartsStudents.add(new Student("Рон Уизли", 1, 80));

        List<Student> beauxbatonsStudents = new ArrayList<>();
        beauxbatonsStudents.add(new Student("Флер Делакур", 7, 130));
        beauxbatonsStudents.add(new Student("Габриэль Делакур", 6, 100));
        beauxbatonsStudents.add(new Student("Аманда Миньон", 5, 80));

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Поймать Снежка", Difficulty.EASY, 50));
        tasks.add(new Task("Собрать 10 грибов-чародеек", Difficulty.NORMAL, 100));
        tasks.add(new Task("Разгадать тайну Философского Камня", Difficulty.IMPOSSIBLE, 500));

        School hogwarts = new School("Хогвартс", hogwartsStudents);
        School beauxbatons = new School("Бобатон", beauxbatonsStudents);


        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, tasks.get(2));
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, tasks.get(1));


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
