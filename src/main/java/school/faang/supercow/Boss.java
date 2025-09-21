package school.faang.supercow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined the battle. Current: " + currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers > 0) {
                currentPlayers--;
                System.out.println(player.getName() + " left the battle. Current: " + currentPlayers);
                lock.notifyAll();
            }
        }
    }

}
