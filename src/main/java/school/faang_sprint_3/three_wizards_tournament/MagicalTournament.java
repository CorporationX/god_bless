package school.faang_sprint_3.three_wizards_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        var tournament = new Tournament();

        var hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        var beauxBatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        var hogwarts = new School("Hogwarts", hogwartsTeam);
        var beauxBatons = new School("BeauxBatons", beauxBatonsTeam);

        var task1 = new Task("Triwizard Tournament", 10, 100);
        var task2 = new Task("Yule Ball Preparations", 5, 50);

        var hogwartsTask = tournament.startTask(hogwarts, task1);
        var beauxBatonsTask = tournament.startTask(beauxBatons, task2);

        var allTasks = CompletableFuture.allOf(hogwartsTask, beauxBatonsTask);
        allTasks.thenAccept(aVoid -> {
            var winner = hogwarts.getTotalPoints() > beauxBatons.getTotalPoints() ? hogwarts : beauxBatons;
            log.info("Winner: {}", winner.name());
            log.info("Total Points: {}", winner.getTotalPoints());
        });

    }
}
