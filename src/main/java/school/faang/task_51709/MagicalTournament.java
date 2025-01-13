package school.faang.task_51709;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            try {
                School completedHogwarts = hogwartsTask.get();
                School completedBeauxbatons = beauxbatonsTask.get();

                System.out.println(completedHogwarts.getName() + " total points: "
                        + completedHogwarts.getTotalPoints());
                System.out.println(completedBeauxbatons.getName() + " total points: "
                        + completedBeauxbatons.getTotalPoints());

                if (completedHogwarts.getTotalPoints() > completedBeauxbatons.getTotalPoints()) {
                    System.out.println("Winner: " + completedHogwarts.getName());
                } else if (completedHogwarts.getTotalPoints() < completedBeauxbatons.getTotalPoints()) {
                    System.out.println("Winner: " + completedBeauxbatons.getName());
                } else {
                    System.out.println("It's a tie!");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }
}

