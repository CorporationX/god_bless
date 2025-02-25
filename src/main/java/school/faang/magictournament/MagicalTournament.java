package school.faang.magictournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    private static final Tournament TOURNAMENT = new Tournament();
    private static final List<Student> HOGWARTS_TEAM = List.of(
            new Student("Harry", 5, 0),
            new Student("Hermione", 5, 0)
    );
    private static final List<Student> BEAUXBATONS_TEAM = List.of(
            new Student("Fleur", 6, 0),
            new Student("Gabrielle", 6, 0)
    );
    private static final School HOGWARTS = new School("Hogwarts", HOGWARTS_TEAM);
    private static final School BEAUXBATONS = new School("Beauxbatons", BEAUXBATONS_TEAM);
    private static final Task TRIWIZARD = new Task("Triwizard Tournament", 4, 100);
    private static final Task YULE_BALL = new Task("Yule Ball Preparations", 2, 50);

    public static void main(String[] args) {
        try {
            CompletableFuture<School> hogwartsTask = TOURNAMENT.startTask(HOGWARTS, TRIWIZARD);
            CompletableFuture<School> beauxbatonsTask = TOURNAMENT.startTask(BEAUXBATONS, YULE_BALL);
            CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

            allTasks.thenRun(() -> {
                int hogwartsPoints = HOGWARTS.getTotalPoint();
                int beauxbatonsPoints = BEAUXBATONS.getTotalPoint();
                log.info("Hogwarts total points: {}", hogwartsPoints);
                log.info("Beauxbatons total points: {}", beauxbatonsPoints);

                if (hogwartsPoints > beauxbatonsPoints) {
                    log.info("Hogwarts wins!");
                } else if (beauxbatonsPoints > hogwartsPoints) {
                    log.info("Beauxbatons wins!");
                } else {
                    log.info("Draw");
                }
            }).join();
        } catch (InterruptedException e) {
            log.error("Execution tasks failed. Exception {}\nStack trace: {}", e, e.getStackTrace());
        }
    }
}
