package bjs2_35742;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    @Getter
    private List<Player> players;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (!canJoinBattle()) {
            System.out.println("No slots available...");
            wait();
        }
        players.add(player);
        currentPlayers++;
        System.out.println("Successfully joined the battle!");
    }

    public synchronized void leaveBattle(Player player) {
        players.remove(player);
        currentPlayers--;
        System.out.println("New slot available!");
        notify();
    }

    public boolean canJoinBattle() {
        return maxPlayers - currentPlayers > 0;
    }
}
