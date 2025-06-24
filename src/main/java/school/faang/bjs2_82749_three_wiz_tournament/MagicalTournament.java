package school.faang.bjs2_82749_three_wiz_tournament;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6), new Student("Gabrielle", 6));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();
        tournament.shutDown();

        School winnerSchool = Stream.of(hogwarts, beauxbatons)
                .max(Comparator.comparingInt(School::getTotalPoints)).orElseThrow();

        System.out.println("Tournament ended 🎉 \nThe winner school is "
                + winnerSchool.getName()
                + " with "
                + winnerSchool.getTotalPoints()
                + " points!");
    }
}
