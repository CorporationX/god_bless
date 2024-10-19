package school.faang.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println("There is no free slots for player " + player.getName());
            wait();
        }
        currentPlayers++;
        System.out.println("The player has joined the battle: " + player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("The player has left the battle: " + player.getName());
        notify();
    }
}
