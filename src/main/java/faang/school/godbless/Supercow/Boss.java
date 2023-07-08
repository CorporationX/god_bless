package faang.school.godbless.Supercow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Boss {
    private int maxPlayers;
    private final List<Player> currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = new ArrayList<>();
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers.size() >= maxPlayers) {
            System.out.println("Maximum number of players has been reached");
            try {
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        currentPlayers.add(player);
        System.out.println(player + " joined to battle | Total: " + currentPlayers.size() + "/" + maxPlayers);
    }

    public synchronized void finishBattle(Player player) {
        currentPlayers.remove(player);
        notifyAll();
        System.out.println(player + " finished battle | Total: " + currentPlayers.size() + "/" + maxPlayers);
    }
}
