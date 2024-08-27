package faang.school.godbless.fourthsprint.robotsbattle;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Tournament {
    public static void main(String[] args) {
        Battle battle = new Battle();
        List<Robot> robots = getRobots();

        List<Future<Robot>> brawls = IntStream.range(0, robots.size() / 2)
                .mapToObj(index -> battle.fight(robots.get(2 * index), robots.get(2 * index + 1)))
                .toList();

        try {
            for (Future<Robot> brawl : brawls) {
                Robot winner = brawl.get();
                System.out.println("\nПобедитель битвы: " + winner.getName());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.shutdown();
    }

    private static List<Robot> getRobots() {
        return List.of(
                new Robot("R2-D2", 5, 7),
                new Robot("C-3PO", 4, 8),
                new Robot("BB-8", 6, 6),
                new Robot("K-2SO", 7, 5),
                new Robot("IG-88", 8, 4),
                new Robot("L3-37", 6, 7)
        );
    }
}
