package MultithreadingSupercow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private final Object lock = new Object();
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized(lock) {
            if (currentPlayers == maxPlayers) {
                lock.wait();
            }
            currentPlayers++;
            System.out.println("=============================================");
            System.out.println(player.getName() + " joined the battle!");
            System.out.println("The number of current players: " + currentPlayers);
            System.out.println("=============================================");
        }
    }

    public void leaveBattle(Player player) throws InterruptedException {
        synchronized(lock) {
            currentPlayers--;
            System.out.println("=============================================");
            System.out.println(player.getName() + " left the battle");
            System.out.println("Current players: " + currentPlayers);
            System.out.println("=============================================");
            lock.notify();
        }
    }
}
