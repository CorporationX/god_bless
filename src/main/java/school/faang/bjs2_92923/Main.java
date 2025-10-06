package school.faang.bjs2_92923;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        Student student1 = new Student("Alice", 1);
        Student student2 = new Student("Bob", 2);
        Student student3 = new Student("Charlie", 2);
        Student student4 = new Student("Daisy", 3);
        Student student5 = new Student("Ethan", 2);
        Student student6 = new Student("Fiona", 4);
        Student student7 = new Student("George", 3);

        School school1 = new School("Hogwarts", Arrays.asList(student1, student2, student3));
        School school2 = new School("Beauxbatons", Arrays.asList(student4, student5, student6, student7));

        Task task1 = new Task("History Exam", 3, 150);
        Task task2 = new Task("Art Contest", 4, 200);

        CompletableFuture<School> futureTask1School1 = tournament.startTask(school1, task1);
        CompletableFuture<School> futureTask2School1 = tournament.startTask(school1, task2);
        CompletableFuture<School> futureTask1School2 = tournament.startTask(school2, task1);
        CompletableFuture<School> futureTask2School2 = tournament.startTask(school2, task2);

        try {
            CompletableFuture.allOf(futureTask1School1, futureTask2School1, futureTask1School2,
                    futureTask2School2).get();
            School updatedSchool1 = futureTask1School1.get();
            School updatedSchool2 = futureTask1School2.get();
            log.info("Final total points for {}: {}", updatedSchool1.getName(), updatedSchool1.getTotalPoints());
            log.info("Final total points for {}: {}", updatedSchool2.getName(), updatedSchool2.getTotalPoints());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error retrieving school results: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        try {
            tournament.executorShutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
