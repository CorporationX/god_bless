package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayers;
    private Object lock = new Object();

    public Boss(int maxplayer) {
        this.maxPlayers = maxplayer;
        this.currentPlayers = new ArrayList<>();
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers.size() >= maxPlayers) {
                lock.wait();
            }
            currentPlayers.add(player);
            System.out.println("Пользователь " + player.getName() + " добавлен к сражению");
        }
    }

    public void endBattle(Player player) {
        synchronized (lock) {
            currentPlayers.remove(player);
            System.out.println("Игрок " + player.getName() + " закончил сражение ");
            lock.notify();
        }
    }
}