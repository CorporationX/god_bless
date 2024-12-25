package school.faang.task_49681;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Set<Player> players = new HashSet<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (players.contains(player)) {
            return;
        }

        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " is waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(player.getName() + " is entering the battle");
        players.add(player);
        currentPlayers++;
    }

    public synchronized void exitBattle(Player player) {
        System.out.println(player.getName() + " is leaving the battle");
        players.remove(player);
        currentPlayers--;
        notify();
    }
}
