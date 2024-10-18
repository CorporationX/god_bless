package school.faang.supercow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Boss {
    private final int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        if (currentPlayers.size() == maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (currentPlayers.size() < maxPlayers) {
            currentPlayers.add(player);
            System.out.println(player.getName() + " присоединился к сражению. Текущие игроки: " + currentPlayers.toString());
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        System.out.println(player.getName() + " покинул сражение. Текущие игроки: " + currentPlayers.toString());
        notify();
    }

}
