package school.faang.BJS2_38970_TriwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        hogwartsTask.thenCombine(beauxbatonsTask, (hogwartsSchool, beauxbatonsSchool) -> {
            int hogwartsPoints = hogwartsSchool.getTotalPoints();
            int beauxbatonsPoints = beauxbatonsSchool.getTotalPoints();
            if (hogwartsPoints > beauxbatonsPoints) {
                log.info("Hogwarts wins with {} points!", hogwartsPoints);
            } else if (beauxbatonsPoints > hogwartsPoints) {
                log.info("Beauxbatons wins with {} points!", beauxbatonsPoints);
            } else {
                log.info("It's a tie with {} points each!", hogwartsPoints);
            }
            return null;
        }).join();
    }
}
