package faang.school.godbless.supercow;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Boss {

    private static final int SLEEP_TIME = 3000;

    private int maxPlayers;
    private int currentPlayers;
    private List<Player> players = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (players) {
            if (currentPlayers == maxPlayers) {
                try {
                    players.wait();
                    System.out.println(player.getName() + " - ждет пока кого-нибудь зарубят...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            players.add(player);
            System.out.println(player.getName() + " - присоединился к битве");
        }

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        killPlayer(player);
    }

    public void killPlayer(Player player) {
        synchronized (players) {
            players.remove(player);
            currentPlayers--;
            System.out.println(player.getName() + " - убит");
            players.notify();
        }
    }
}
