package supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        List<Player> players = getPlayers(5);

        players.stream()
                .map(player -> new Thread(() -> player.startBattle(boss)))
                .forEach(Thread::start);
    }

    public static List<Player> getPlayers(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(new Player(String.format("player %d", i)));
        }
        return players;
    }
}
