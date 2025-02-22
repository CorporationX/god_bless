package school.faang.supercow;

import lombok.Getter;


public class Boss {
    @Getter
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.printf("%s ожидает свободного слота для сражения с боссом\n", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.printf("%s ожидание прервано\n", player.getName());
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            System.out.printf("%s присоединился к сражению с боссом\n", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("%s покинул сражение\n", player.getName());
            lock.notify();
        }
    }
}
