package faang.school.godbless.game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Boss {
    private final int maxPlayers;
    private final List<Player> players;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.players = new ArrayList<>(maxPlayers);
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (players.size() >= maxPlayers) {
                wait();
            }
            System.out.println("Add new player in battle");
            players.add(player);
            System.out.println("Current players " + players);
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException in joinBattle");
        }
    }

    public synchronized void killPlayer() {
        try {
            if (players.size() == maxPlayers) {
                int leaver = ThreadLocalRandom.current().nextInt(players.size());
                System.out.println(players.get(leaver) + " decided to leave");
                players.remove(leaver);
                Thread.sleep(1000L);
            }
            notify();
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException in killPlayer");
        }
    }

}
