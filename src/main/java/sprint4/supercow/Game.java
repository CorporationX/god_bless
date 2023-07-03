package sprint4.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    private static final Boss BOSS = new Boss("The Golem of Shit Code", 3);
    private static final List<Player> PLAYERS = List.of(
            new Player("Bob"), new Player("fuker"), new Player("ninja"), new Player("LOLO121"),
            new Player("Kk231Ad"), new Player("M1k10"), new Player("****"), new Player("Mystic")
    );

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(BOSS::fight);

        for (Player player : PLAYERS) {
            service.execute(() -> player.startBattle(BOSS));
        }
        service.shutdown();

        try {
            service.awaitTermination(20, TimeUnit.SECONDS);
            BOSS.setBattleIsOn(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
