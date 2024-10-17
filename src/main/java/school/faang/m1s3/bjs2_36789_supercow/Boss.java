package school.faang.m1s3.bjs2_36789_supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();
    private Random random = new Random();

    protected void joinBattle(Player player) {
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                System.out.println("The party is full!");
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
                }
            }
            currentPlayers.add(player);
            System.out.println(player.getName() + " joins the battle!");
        }
    }

    public void killPlayer() {
        synchronized (currentPlayers) {
            int playerIndex = random.nextInt(currentPlayers.size());
            System.out.println(currentPlayers.get(playerIndex).getName() + " is killed!");
            currentPlayers.remove(playerIndex);
            currentPlayers.notify();
        }
    }
}
