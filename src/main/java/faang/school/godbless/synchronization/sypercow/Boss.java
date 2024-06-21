package faang.school.godbless.synchronization.sypercow;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() >= maxPlayers) {
            try {
                System.out.println(String.format("Slots is full! %s please wait....", player.getName()));
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(String.format("%s joined the battle", player.getName()));
        currentPlayers.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers.contains(player)) {
            System.out.println(String.format("%s left the battle", player.getName()));
            currentPlayers.remove(player);
            this.notify();
        }
    }
}


