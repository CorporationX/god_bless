package school.faang.supercow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private final Object lock = new Object();
    private int maxPlayers;
    private int currentPLayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPLayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPLayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting for a next free slot to fight the Boss.");
            wait();
        }
        currentPLayers++;
        System.out.println(player.getName() + " has joined to the fight with the Boss!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPLayers--;
        System.out.println(player.getName() + " has finished his fight with the Boss!");
        notify();
    }


}
