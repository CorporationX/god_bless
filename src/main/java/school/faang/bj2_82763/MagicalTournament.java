package school.faang.bj2_82763;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0),
                new Student("Ron", 5, 0)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );
        List<Student> durmstrangTeam = List.of(
                new Student("Viktor", 7, 0),
                new Student("Ivan", 6, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        School durmstrang = new School("Durmstrang", durmstrangTeam);

        Task task1 = new Task("Triwizard Maze", 8, 80);
        Task task2 = new Task("Dragon Challenge", 10, 100);
        Task task3 = new Task("Mermaid Rescue", 6, 60);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task3);
        CompletableFuture<School> durmstrangTask = tournament.startTask(durmstrang, task1);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, durmstrangTask);

        allTasks.join();

        List<School> schools = List.of(
                hogwartsTask.join(),
                beauxbatonsTask.join(),
                durmstrangTask.join()
        );

        School winner = schools.stream()
                .max((s1, s2) -> Integer.compare(s1.getTotalPoints(), s2.getTotalPoints()))
                .orElseThrow();

        System.out.println("Турнир завершён!");
        for (School school : schools) {
            System.out.println(school.getName() + " набрала " + school.getTotalPoints() + " очков");
        }

        System.out.println("Победитель: " + winner.getName() + " с " + winner.getTotalPoints() + " очками!");

        tournament.shutdown();
    }
}
