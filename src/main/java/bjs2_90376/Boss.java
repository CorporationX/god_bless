package bjs2_90376;

public class Boss {
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
                    System.out.println(player.name() + " ждёт свободного слота для сражения с боссом.");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(player.name() + " был прерван во время ожидания.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            currentPlayers++;
            System.out.println(player.name() + " присоединился к сражению с боссом!");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.name() + " завершил сражение с боссом!");
            lock.notify(); // будим одного ожидающего игрока
        }
    }
}