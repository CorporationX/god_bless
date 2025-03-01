package school.faang.triwizard.tournament;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> teamHogwarts = List.of(new Student("Harry", 5, 0), new Student("Cedric", 7, 0));
        List<Student> teamDurmstrang = List.of(new Student("Victor", 7, 0), new Student("Gellert", 7, 0));
        List<Student> teamBeauxbatons = List.of(new Student("Fleur", 8, 0), new Student("Gabrielle", 4, 0));

        School hogwarts = new School("Hogwarts", teamHogwarts);
        School durmstrang = new School("Durmstrang", teamDurmstrang);
        School beauxbatons = new School("Beauxbatons", teamBeauxbatons);

        Task task1 = new Task("Battle with the dragon", 7, 100);
        Task task2 = new Task("Rescuing a prisoner", 8, 200);
        Task task3 = new Task("Passing the Labyrinth", 10, 300);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> durmstrangTask = tournament.startTask(durmstrang, task2);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task3);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, durmstrangTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            List<School> schools = Arrays.asList(hogwarts, durmstrang, beauxbatons);

            int maxPoints = schools.stream()
                    .mapToInt(School::getTotalPoints)
                    .max()
                    .orElse(0);

            List<School> winners = schools.stream()
                    .filter(school -> school.getTotalPoints() == maxPoints)
                    .toList();

            if (winners.size() == 1) {
                System.out.printf("Winner: %s with %d points!%n", winners.get(0).getName(), maxPoints);
            } else {
                System.out.println("Draw between schools");
                winners.forEach(winner -> System.out.printf("%s with %d points%n", winner.getName(), maxPoints));
            }
        }).join();
    }
}
