package faang.school.godbless.supercow;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Boss {

    private int maxPlayers;
    private static int currentPlayers;
    private static List<Player> players = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @SneakyThrows
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

        Thread.sleep(3000);

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
