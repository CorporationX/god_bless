package school.faang.task_50763;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = ExecutorServiceFactory.createExecutorService();
        Tournament tournament = new Tournament(executorService);

        List<School> schools = List.of(
                new School("Hogwarts", List.of(
                        new Student("Harry", 5, 95),
                        new Student("Hermione", 5, 98),
                        new Student("Ron", 5, 50)
                )),
                new School("Beauxbatons", List.of(
                        new Student("Fleur", 6, 88),
                        new Student("Gabrielle", 6, 72)
                )),
                new School("Durmstrang", List.of(
                        new Student("Viktor", 7, 90),
                        new Student("Igor", 7, 85)
                ))
        );

        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", 10, 100),
                new Task("Potions Exam", 8, 80),
                new Task("Quidditch Match", 6, 60)
        );

        tournament.startTournament(schools, tasks);
    }
}