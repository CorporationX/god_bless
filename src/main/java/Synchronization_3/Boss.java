package Synchronization_3;

import java.util.ArrayList;
import java.util.List;

public class Boss {

    private int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() == maxPlayers) {
            try {
                currentPlayers.wait();
            } catch (InterruptedException e) {
                System.out.println("Count players overdraw maximum. Please wait.");
            }
        }
        currentPlayers.add(player);
    }

    public synchronized void disconnectBatle(Player player) {
        try {
            Thread.sleep(1000);
            System.out.println(player.getName() + " winn boss");
        } catch (InterruptedException e) {
            System.out.println(player.getName() + " lose boss");
        }
        currentPlayers.remove(player);
        currentPlayers.notify();
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public List<Player> getCurrentPlayers() {
        return currentPlayers;
    }
}
