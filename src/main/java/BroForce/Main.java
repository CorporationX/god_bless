package BroForce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            players.add(new Player(game));
        }

        for (Player player : players) {
            player.start();
        }
        for (Player player : players) {
            player.join();
        }
    }
}
