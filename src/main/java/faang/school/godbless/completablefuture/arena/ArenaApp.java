package faang.school.godbless.completablefuture.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ArenaApp {

    public static void main(String[] args) {
        List<Robot> robots = getRobotsForTest();
        Battle battle = new Battle(robots);

        CompletableFuture<Optional<Robot>> winnerFuture = battle.fight();
        Optional<Robot> winner = winnerFuture.join();

        winner.ifPresentOrElse(
                robot -> printWinner(robot),
                () -> System.out.println("There is no winner today. He-he x)")
        );
    }

    private static void printWinner(Robot robot) {
        System.out.printf("""

                ...:::::::::::::The Winner::::::::::::...
                ***************** %s *****************
                It has %d HP
                """, robot.getName(), robot.getHp());
    }

    private static ArrayList<Robot> getRobotsForTest() {
        return new ArrayList<>(List.of(
                new Robot(1, "Robot1", 1000, 200, 1.0),
                new Robot(2, "Robot2", 1000, 150, 0.75),
                new Robot(3, "Robot3", 1000, 100, 0.5),
                new Robot(3, "Robot4", 1000, 100, 0.5),
                new Robot(3, "Robot5", 500, 300, 0.5)
        ));
    }

}
