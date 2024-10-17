package school.faang.multithreading.synchron.supercow;

import lombok.SneakyThrows;

public class Boss {
    private final Object lock = new Object();
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (lock) {
            if (maxPlayers - currentPlayers <= 0) {
                System.out.println(player.getName() + " ждет начала битвы.");
                lock.wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к битве.");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " покинул битву.");
            lock.notify();
        }
    }
}
