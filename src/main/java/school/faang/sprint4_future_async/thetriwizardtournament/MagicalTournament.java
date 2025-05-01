package school.faang.sprint4_future_async.thetriwizardtournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        CopyOnWriteArrayList<Student> hogwartsTeam = new CopyOnWriteArrayList<>(List.of(
                new Student("Harry", 5, new AtomicInteger(0)),
                new Student("Hermione", 5, new AtomicInteger(0))
        ));
        CopyOnWriteArrayList<Student> beauxbatonsTeam = new CopyOnWriteArrayList<>(List.of(
                new Student("Fleur", 6, new AtomicInteger(0)),
                new Student("Gabrielle", 6, new AtomicInteger(0))
        ));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 5, 50);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println(hogwarts.getName() + " выиграл турнир!");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println(beauxbatons.getName() + " выиграл турнир!");
            } else {
                System.out.println("Победила дружба!");
            }
        });

        tournament.shutdown();
    }
}