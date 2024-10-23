package turnir;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {{
        Tournament tournament = new Tournament();
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 2, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 3, 0), new Student("Gabrielle", 3, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwardsTask1 = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxTask1 = tournament.startTask(beauxbatons, task1);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(hogwardsTask1, beauxTask1);
        allTask.thenRun(() ->{
            if (hogwarts.getTotalPoints(task1) > beauxbatons.getTotalPoints(task1)) {
                System.out.println(hogwarts.getName() + " wins the tournament");
            } else {
                System.out.println(beauxbatons.getName()+" wins the tournament");
            }
            });
        allTask.join();
        }
    }
}
