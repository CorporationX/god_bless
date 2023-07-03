package sprint4.supercow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Boss {
    private static final Random RANDOM = new Random();
    private final String name;
    private final List<Player> playersPool;
    private final int maxPlayers;
    private int currentPlayers;
    private boolean battleIsOn = true;

    public Boss(String name, int maxPlayer) {
        this.name = name;
        this.maxPlayers = maxPlayer;
        this.playersPool = new ArrayList<>();
    }

    public void fight() {
        while (anticipationOfBattle()) {
            System.out.printf("Boss %s attacks!\n", name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
            knockOutPlayer();
        }
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            addPlayer(player);
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("A player has stepped out of the queue");
            }
            addPlayer(player);
        }
    }

    private synchronized void knockOutPlayer() {
        Player player = playersPool.remove(RANDOM.nextInt(currentPlayers));
        System.out.printf("%s loses %s!\n", player.name(), name);
        currentPlayers--;
        notifyAll();
    }

    private boolean anticipationOfBattle() {
        while (currentPlayers == 0 && battleIsOn) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException("Work interrupted");
            }
        }
        return battleIsOn;
    }

    private void addPlayer(Player player) {
        playersPool.add(player);
        System.out.printf("%s joined the battle\n", player.name());
        currentPlayers++;
    }
}
