package school.faang.hogwarts;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", DifficultyType.HARD, 100);
        Task task2 = new Task("Yule Ball Preparations", DifficultyType.MEDIUM, 50);

        CompletableFuture<School> startTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> startTask2 = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(startTask, startTask2)
                .thenApply(i -> {
                    School result1 = startTask.join();
                    School result = startTask2.join();
                    if (result1.getTotalPoints() > result.getTotalPoints()) {
                        return result1;
                    } else {
                        return result;
                    }
                })
                .join();
    }
}
