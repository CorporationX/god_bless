package ru.kraiush.BJS2_36982;

public class Boss {
    private final Object lock = new Object();
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println("There are no available slots. " + player.getName() + ", please wait!");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined the battle with Boss!");
        }
    }

    public void endBattle(Player player) {
        synchronized (lock) {
            System.out.println(player.getName() + " ended the battle with Boss.");
            currentPlayers--;
            lock.notify();
        }
    }
}
