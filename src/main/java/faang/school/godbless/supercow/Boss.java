package faang.school.godbless.supercow;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private List<Player> players;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
        this.players = new ArrayList<>();
    }

    Object lock = new Object();

    private void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentPlayers++;
                players.add(player);
                System.out.println(player.getName() + " Joined the battle ");

                currentPlayers--;
                players.remove(player);
                System.out.println(player.getName() + " Finished the battle");
                lock.notify();

            }
        }
    }
}
