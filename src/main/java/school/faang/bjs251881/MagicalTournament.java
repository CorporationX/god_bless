package school.faang.bjs251881;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
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

        val futuresList = Arrays.asList(hogwartsTask, beauxbatonsTask);
        CompletableFuture<?>[] futuresArray = futuresList.toArray(new CompletableFuture[0]);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futuresArray);

        allTasks.thenRun(() -> {
            List<School> schools = getSchools(futuresList);

            schools.stream()
                    .max(Comparator.comparingInt(School::getTotalPoints))
                    .ifPresent(school -> System.out.println(school.getName()
                            + " wins the tournament with a total of " + school.getTotalPoints() + " points!"));
        });
        allTasks.join();
    }

    private static List<School> getSchools(List<CompletableFuture<School>> futuresList) {
        return futuresList.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException ex) {
                log.error("The task has been aborted!{}", String.valueOf(ex));
                Thread.currentThread().interrupt();
                throw new RuntimeException(ex);
            }
        }).toList();
    }
}
