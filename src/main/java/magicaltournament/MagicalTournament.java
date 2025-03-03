package magicaltournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School(
                "Hogwarts",
                List.of(
                        new Student("Harry", 5, 0),
                        new Student("Hermione", 5, 0)
                )
        );

        School beauxbatons = new School(
                "Beauxbatons",
                List.of(
                        new Student("Fleur", 6, 0),
                        new Student("Gabrielle", 6, 0)
                )
        );

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture.allOf(
                tournament.startTask(hogwarts, task1),
                tournament.startTask(beauxbatons, task2)
        ).thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int beauxbatonsPoints = beauxbatons.getTotalPoints();

            log.info("Hogwarts points: {}, Beauxbatons points: {}", hogwartsPoints, beauxbatonsPoints);

            Map<Boolean, String> result = Map.of(
                    hogwartsPoints > beauxbatonsPoints, "Hogwarts wins!",
                    beauxbatonsPoints > hogwartsPoints, "Beauxbatons wins!"
            );
            log.info(result.getOrDefault(true, "It's a tie!"));
        }).join();
        tournament.shutdown();
    }
}
