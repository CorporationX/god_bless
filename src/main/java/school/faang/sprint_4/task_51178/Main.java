package school.faang.sprint_4.task_51178;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);

        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        Tournament tournament = new Tournament();
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.get();

        int hogwartsPoints = hogwarts.getTotalPoints();
        int beauxbatonsPoints = beauxbatons.getTotalPoints();

        if (hogwartsPoints > beauxbatonsPoints) {
            System.out.println("Победил Хогвартс");
        } else if (beauxbatonsPoints > hogwartsPoints) {
            System.out.println("Победил Шармбатон");
        } else if (hogwartsPoints == beauxbatonsPoints) {
            System.out.println("Ничья");
        }
    }
}
