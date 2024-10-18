package school.faang.supercow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Boss {
    private String name;
    private int maxPlayers;
    private int currentPlayers;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println("The player " + player.getName() + " waits for a slot to become available to enter the battle.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("Caught exception: ", e);
            }
        }
        currentPlayers++;
        System.out.println("The player " + player.getName() + " joined the battle with the boss " + name);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("The player " + player.getName() + " has completed the boss fight");
        notify();
    }
}
