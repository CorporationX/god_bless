package faang.school.godbless.module.third.synchronization.supercow;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();
    
    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
    
    public void joinBattle(Player player) {
        String playerName = player.getName();
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                System.out.println("Все слоты заняты");
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf("Игрок \"%s\" присоединяется к сражению %n", playerName);
            currentPlayers.add(player);
            System.out.printf(
                "Игроки %s сражаются с боссом %n",
                String.join(",", currentPlayers.stream().map((curPlayer) -> curPlayer.getName()).toList())
            );
        }
    }
    
    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {
            System.out.printf("Игрок %s выходит из битвы с боссом %n", player);
            currentPlayers.remove(player);
            currentPlayers.notify();
        }
    }
}
