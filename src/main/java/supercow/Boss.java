package supercow;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> players = new ArrayList<>();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (players) {
            if (players.size() >= maxPlayers) {
                System.out.println("Игорок стоит в очереди");
                players.wait();
            }
            players.add(player);
            System.out.println("Игрок присоединился к битве");
        }
    }

    public void leaveBattle(Player player) throws InterruptedException {
        synchronized (players) {
            players.remove(player);
            System.out.println("Игрок вышел из битвы");
            players.notify();
        }
    }
}
