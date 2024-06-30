package faang.school.godbless.multithreading_synchronization.task_3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        System.out.println("Player " + player.name() + " started battle");
        if (currentPlayers.size() >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread was interrupted while " + player.name() + " was preparing for fight " + e);
            }
        }
        currentPlayers.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println("Player " + player.name() + " ended battle");
        currentPlayers.remove(player);
        notify();
    }
}
