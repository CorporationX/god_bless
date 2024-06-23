package Supercow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYER_BOSS_KING_WARRIOR = 5;
    private static final Boss bossKingWarrior = new Boss("King Warrior", MAX_PLAYER_BOSS_KING_WARRIOR);
    private static final ExecutorService executorAttackKingWarrior = Executors.newFixedThreadPool(MAX_PLAYER_BOSS_KING_WARRIOR);

    public static void main(String[] args) throws InterruptedException {
        List<Player> playersAttackWarrior = Arrays.asList(new Player("Tom"), new Player("Rob"), new Player("Bob"),
                new Player("Misha"), new Player("Fill"), new Player("Mot"));

        attackBossWarrior(playersAttackWarrior);
    }

    public static void attackBossWarrior(List<Player> players) throws InterruptedException {
        for (Player player : players)
            executorAttackKingWarrior.execute(() -> player.startBattle(bossKingWarrior, player));
        executorAttackKingWarrior.shutdown();
        executorAttackKingWarrior.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("King Warrior is loss");
    }
}
