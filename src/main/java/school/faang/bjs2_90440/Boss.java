package school.faang.bjs2_90440;

public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers = 3;
    private int currentPlayers = 0;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers == maxPlayers) {
                try {
                    System.out.printf("Игрок %s ждет свою очередь.%n", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.printf("Игрок %s не дождался и ушел.", player.getName());
                }
            }
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
        }
    }
}
