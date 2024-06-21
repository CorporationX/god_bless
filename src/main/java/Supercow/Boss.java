package Supercow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private final String name;
    private final int maxPlayers;
    private static int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers >= maxPlayers) {
            wait();
        }
        currentPlayers++;
        battle(player);
    }

    public synchronized void battle(Player player) throws InterruptedException {
        System.out.println(player.getName() + " started a boss battle: " + name);
        Thread.sleep(3000);
        currentPlayers--;
        notifyAll();
    }
}
