package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final Boss BOSS = new Boss(2, 3);
    private static final List<Player> PLAYERS = new ArrayList<>();

    public static void main(String[] args) {
        Player playerHarry = new Player("Harry");
        Player playerRon = new Player("Ron");
        Player playerDraco = new Player("Draco");
        PLAYERS.add(playerDraco);
        PLAYERS.add(playerRon);
        PLAYERS.add(playerHarry);

        for (Player player : PLAYERS) {
            Thread thread = new Thread(() -> {
                try {
                    player.doBattle(BOSS);
                } catch (InterruptedException | RuntimeException e) {
                    log.error(e.getMessage(), e);
                }
            });
            thread.start();
        }
    }
}
