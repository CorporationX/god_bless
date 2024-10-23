package school.faang.starwarsarena;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();
        List<Robot> robots = List.of(
                new Robot("R2-D2", 5, 7),
                new Robot("C-3PO", 4, 8),
                new Robot("BB-8", 6, 7),
                new Robot("DD-4", 5, 8)
        );
        for (int i = 0; i < robots.size(); i++) {
            for (int j = i + 1; j < robots.size(); j++) {
                Future<Robot> winnerFuture = battle.fight(robots.get(i), robots.get(j));
                try {
                    Robot winner = winnerFuture.get();
                    System.out.println("The winner of battle between robots: " + robots.get(i).getName() + " and " + robots.get(j).getName() + " is " + winner.getName());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    throw new IllegalStateException("Battle was unexpectedly interrupted");
                }
            }
        }
        battle.executorShutDown();
    }
}
