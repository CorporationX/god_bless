package supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void maxPlayers() {
        System.out.println("Maximum players allowed is " + maxPlayers);
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting to join battle... ");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle! Current: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " left the battle. Current: " + currentPlayers);
        notify();
    }
}
