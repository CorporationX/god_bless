package school.faang.supercow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();
    private final List<Player> activePlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println(player.getName() + " is waiting for a slot to fight the boss...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(player.getName() + " was interrupted while waiting.");
                    return;
                }
            }

            currentPlayers++;
            activePlayers.add(player);
            System.out.println(player.getName() + " joined the battle! (" + currentPlayers + "/" + maxPlayers + ")");
        }
    }
        public void leaveBattle (Player player){
            synchronized (lock) {
                if (activePlayers.remove(player)) {
                    currentPlayers--;
                    System.out.println(player.getName() + " has left the battle. (" + currentPlayers + "/" + maxPlayers + ")");
                    lock.notify();
                }
            }
        }
        public void showActivePlayers() {
            String activePlayersList = activePlayers.stream()
                    .map(Player::getName)
                    .collect(Collectors.joining(", "));
            System.out.println("Active players fighting the boss: " + activePlayersList);
        }
    }


