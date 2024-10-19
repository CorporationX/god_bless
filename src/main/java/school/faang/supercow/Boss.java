package school.faang.supercow;

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
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Join Battle - wait is interrupted");
                    e.printStackTrace();
                    throw new IllegalStateException(e);
                }
            }
            System.out.println("Player " + player.getName() + " has started the battle.Current players: " + currentPlayers);
            currentPlayers++;
        }
    }

    public void finishBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println("Player " + player.getName() + " has finished the battle. Current players: " + currentPlayers);
            lock.notify();
        }
    }
}
