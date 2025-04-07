package school.faang.bro_force;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game started");
        List<Player> players = new ArrayList<>();
        List<String> names = new ArrayList<>(List.of("Steve", "John"));
        for (int i = 0; i < names.size(); i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Player curPlayer = new Player(names.get(i));
            int waitTime = 5000 * (names.size() - i);
            new Thread(() -> curPlayer.scorePoints(5, waitTime)).start();
        }
        for (Player player : players) {
            player.gameOver();
        }
    }
}
