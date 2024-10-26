package school.faangSprint4.t07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BattleManager {
    private final Battle battle;
    private final List<Robot> robots;
    private final List<Future<Robot>> battles;

    public BattleManager(Battle battle, List<Robot> robots) {
        this.battle = battle;
        this.robots = robots;
        this.battles = new ArrayList<>();
    }

    public void arrangeBattles() {
        for (int i = 0; i < robots.size(); i++) {
            for (int j = i + 1; j < robots.size(); j++) {
                battles.add(battle.fight(robots.get(i), robots.get(j)));
            }
        }
    }

    public void displayResults() {
        try {
            for (int i = 0; i < battles.size(); i++) {
                System.out.printf("Battle %d winner: %s%n",
                        i + 1,
                        battles.get(i).get().name());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            battle.shutdown();
        }
    }
}