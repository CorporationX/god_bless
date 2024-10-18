package dima.evseenko.supercow;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Boss {
    private final List<Player> players = new ArrayList<>();

    private int maxPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (players.size() + 1 > maxPlayers) {
            System.out.printf("Игрок %s ждет пока освободится место...%n", player.getName());
            this.wait();
        }
        players.add(player);
        System.out.printf("Игрок %s присоединился к сражению с боссом%n", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        players.remove(player);
        System.out.printf("Игрок %s закончил сражение с боссом%n", player.getName());
        this.notify();
    }
}
