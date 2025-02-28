package school.faang.triwizard.tournament;

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
            int hogwartsPoints = hogwarts.getTotalPoints();
            int durmstrangPoints = durmstrang.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            if (hogwartsPoints > durmstrangPoints && hogwartsPoints > beauxbatonsPoints) {
                System.out.printf("%s wins the tournament with %d points!", hogwarts.getName(), hogwartsPoints);
            } else if (durmstrangPoints > hogwartsPoints && durmstrangPoints > beauxbatonsPoints) {
                System.out.printf("%s wins the tournament with %d points!", durmstrang.getName(), durmstrangPoints);
            } else if (beauxbatonsPoints > hogwartsPoints && beauxbatonsPoints > durmstrangPoints) {
                System.out.printf("%s wins the tournament with %d points!", beauxbatons.getName(), beauxbatonsPoints);
            }
        }).join();
    }
}
