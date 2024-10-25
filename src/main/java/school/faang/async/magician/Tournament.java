package school.faang.async.magician;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Tournament {

  public CompletableFuture<School> startTask(School school, Task task) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        school.getTeam().forEach(student -> student.addPoints(task.getReward()));
        Thread.sleep(1000);
        log.info("calculating : {}", task.getName());
      } catch (InterruptedException | RuntimeException e) {
        log.error("Caught exception: ", e);
      }
      return school;
    });
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Tournament tournament = new Tournament();

    List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
    List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
        new Student("Gabrielle", 6, 0));
    School hogwarts = new School("Hogwarts", hogwartsTeam);
    School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

    Task task1 = new Task("Triwizard Tournament", 10, 100);
    Task task2 = new Task("Yule Ball Preparations", 5, 50);

    CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
    CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

    CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

    allTasks.join();

    allTasks.thenRun(() -> {
      System.out.println(beauxbatons + " " + beauxbatons.getTotalPoints());
      System.out.println(hogwarts + " " + hogwarts.getTotalPoints());
      if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
        System.out.println(hogwarts.getName() + " wins the tournament!");
      }
    });
  }
}
