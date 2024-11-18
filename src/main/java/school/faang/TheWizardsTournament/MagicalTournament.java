package school.faang.TheWizardsTournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) throws InterruptedException {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));

        List<School> schools = List.of(
                new School("Hogwarts", hogwartsTeam),
                new School("Beauxbatons", beauxbatonsTeam)
        );

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(schools.get(0), task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(schools.get(1), task2);


        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            tournament.shutdown();

            School winnerSchool = schools.stream()
                    .max((school1, school2) -> school1.getTotalPoints() - school2.getTotalPoints())
                    .orElse(null);

            System.out.printf("WINNER!!! -> %s\n", winnerSchool.getName());
        });
    }
}
