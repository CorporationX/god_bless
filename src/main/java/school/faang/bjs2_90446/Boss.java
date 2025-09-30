package school.faang.bjs2_90446;


public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(player.getName() + " был прерван во время ожидания.");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к сражению с боссом!");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " завершил сражение с боссом!");
            lock.notify();
        }
    }
}
