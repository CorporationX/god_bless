package faang.school.godbless.BJS2_12629;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = new ArrayList<>();
    }

    synchronized void joinBattle(Player player){
        if (currentPlayers.size() < maxPlayers) {
            System.out.println("Добавлен игрок: " + player);
            currentPlayers.add(player);
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized public void endPlaying(Player player) {
        currentPlayers.remove(player);
        System.out.println("Удален игрок: " + player);
        notify();
    }
}
