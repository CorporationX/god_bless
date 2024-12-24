package school.faang.bjs49709;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            players.add(new Player("Player " + i));
        }
        players.forEach(player -> {
            new Thread(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });
    }
}
