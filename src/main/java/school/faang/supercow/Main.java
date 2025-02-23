package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Boss boss = new Boss(2, 3);

        Player playerHarry = new Player("Harry");
        Player playerRon = new Player("Ron");
        Player playerDraco = new Player("Draco");
        players.add(playerDraco);
        players.add(playerRon);
        players.add(playerHarry);

        for (Player player : players) {
            Thread thread = new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException | RuntimeException e) {
                    log.error(e.getMessage(), e);
                }
            });
            thread.start();
        }
    }
}
