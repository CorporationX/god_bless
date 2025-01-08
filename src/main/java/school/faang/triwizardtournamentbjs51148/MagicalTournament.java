package school.faang.triwizardtournamentbjs51148;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    private static final Logger logger = LoggerFactory.getLogger(MagicalTournament.class);

    private static final int HOGWARTS_YEAR = 5;
    private static final int BEAUXBATONS_YEAR = 6;
    private static final int HOGWARTS_POINTS = 0;
    private static final int BEAUXBATONS_POINTS = 0;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", HOGWARTS_YEAR,
                        HOGWARTS_POINTS),
                new Student("Hermione", HOGWARTS_YEAR, HOGWARTS_POINTS));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", BEAUXBATONS_YEAR,
                        BEAUXBATONS_POINTS),
                new Student("Gabriele", BEAUXBATONS_YEAR, BEAUXBATONS_POINTS));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask,
                beauxbatonsTask);

        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            logger.info("Hogwarts total points: {}", hogwartsPoints);
            logger.info("Beauxbatons total points: {}", beauxbatonsPoints);

            if (hogwartsPoints > beauxbatonsPoints) {
                logger.info("Hogwarts wins the tournament!");
            } else if (beauxbatonsPoints > hogwartsPoints) {
                logger.info("Beauxbatons wins the tournament!");
            } else {
                logger.info("It's a tie!");
            }
        }).join();
    }
}
