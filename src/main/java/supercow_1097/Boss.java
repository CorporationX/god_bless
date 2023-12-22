package supercow_1097;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private static List<Player> players = new ArrayList<>();
    private static final int MAX_PLAYERS = 3;
    private static int currentPlayers;
    private static Object lock = new Object();

    public void joinBattle(Player player) {

        synchronized (lock) {
            if (currentPlayers == MAX_PLAYERS) {
                System.out.println(player.getName() + " ожидает возможности присоединиться к сражению");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Что-то пошло не так");
                }
            }
            players.add(player);
            System.out.println("Игрок " + player.getName() + " присоединился к сражению");
            currentPlayers = players.size();
        }

        try {
            Thread.sleep(5000);
            synchronized (lock) {
                players.remove(player);
                System.out.println(player.getName() + " покинул сражение");
                lock.notify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Что-то пошло не так");
        }
    }
}