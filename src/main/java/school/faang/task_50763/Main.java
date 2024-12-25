package school.faang.task_50763;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {

        School hogwarts = new School("Hogwarts");
        hogwarts.addStudent(new Student("Harry", 5));
        hogwarts.addStudent(new Student("Hermione", 5));
        hogwarts.addStudent(new Student("Ron", 5));

        School beauxbatons = new School("Beauxbatons");
        beauxbatons.addStudent(new Student("Fleur", 6));
        beauxbatons.addStudent(new Student("Gabrielle", 6));

        School durmstrang = new School("Durmstrang");
        durmstrang.addStudent(new Student("Viktor", 7));
        durmstrang.addStudent(new Student("Igor", 7));

        List<School> schools = List.of(hogwarts, beauxbatons, durmstrang);

        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", 10, 100),
                new Task("Potions Exam", 8, 80),
                new Task("Quidditch Match", 6, 60)
        );

        ExecutorService executorService = ExecutorServiceFactory.createExecutorService();
        Tournament tournament = new Tournament(executorService);

        tournament.startTournament(schools, tasks);

        executorService.shutdown();
    }
}