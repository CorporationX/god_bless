package faang.school.godbless.mags;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
  public static void main(String[] args) {
    Tournament tournament = new Tournament();

    List<Student> hogwartsStudents = Arrays.asList(
        new Student("Harry", 3),
        new Student("Hermione", 6),
        new Student("Ron", 9)
    );

    List<Student> beauxbatonsStudents = Arrays.asList(
        new Student("Gabrielle", 4),
        new Student("Nicolas", 7),
        new Student("Celine", 10)
    );


    School hogwarts = new School("hogwarts", hogwartsStudents);
    School beauxbatons = new School("beauxbatons", beauxbatonsStudents);

    Task hogwartsTask = new Task();
    Task beauxbatonsTask = new Task();

    // Запуск заданий
    CompletableFuture<School> hogwartsTournament = tournament.startTask(hogwarts, hogwartsTask);
    CompletableFuture<School> beauxbatonsTournament = tournament.startTask(beauxbatons, beauxbatonsTask);

    // Обработка результатов заданий
    CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTournament, beauxbatonsTournament);
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
