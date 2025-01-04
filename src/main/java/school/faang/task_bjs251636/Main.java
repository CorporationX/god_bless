package school.faang.task_bjs251636;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5),
                new Student("Hermione", 5));
        List<Student> dreamTeam = List.of(new Student("Fleur", 6),
                new Student("Gabrielle", 6));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", dreamTeam);

        Task task1 = new Task("Triwizard Tournament", 4, 100);
        Task task2 = new Task("Yule Ball Preparations", 2, 40);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(tournament.startTask(hogwarts, task1),
                tournament.startTask(beauxbatons, task2));

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println(hogwarts.getName() + " wins the tournament!");
            }else if(hogwarts.getTotalPoints() == beauxbatons.getTotalPoints()){
                System.out.println("ничья");
            }else {
                System.out.println(beauxbatons.getName() + " wins the tournament!");
            }
        }).join();
    }
}
