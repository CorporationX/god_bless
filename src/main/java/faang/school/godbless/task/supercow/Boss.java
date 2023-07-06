package faang.school.godbless.task.supercow;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Boss {
    private final int maxPlayers;
    private final Set<Player> currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = new HashSet<>();
    }

    public void joinBattle(Player player) throws IllegalAccessException {
        synchronized (currentPlayers) {
            if (currentPlayers.contains(player)) {
                throw new IllegalAccessException(player.getLogin() + " is already fighting with boss");
            }

            if (currentPlayers.size() == maxPlayers) {
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("The lobby is already full, " + player.getLogin() + ", please wait...");
            }

            currentPlayers.add(player);
        }
    }
}
