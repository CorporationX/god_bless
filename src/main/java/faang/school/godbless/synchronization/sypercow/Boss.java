package faang.school.godbless.synchronization.sypercow;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = new ArrayList<>();
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() >= maxPlayers) {
            try {
                System.out.println("Slots is full. Please wait.");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentPlayers.add(player);
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers.contains(player)) {
            currentPlayers.remove(player);
            this.notify();
        }
    }
}


