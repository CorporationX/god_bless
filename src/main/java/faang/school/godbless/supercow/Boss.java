package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        try {
            if (currentPlayers.size() >= maxPlayers) {
                System.out.println("The battle is full, please wait");
                wait();
            }
            currentPlayers.add(player);
            System.out.println(player + " are added");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void endPlaying(Player player) {
        currentPlayers.remove(player);
        notify();
        System.out.println(player + " is removed");
    }

}
