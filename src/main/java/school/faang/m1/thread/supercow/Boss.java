package school.faang.m1.thread.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                System.out.println("[joinBattle] " + player + ": reached maximum: "
                        + maxPlayers + ". Waiting empty slot ...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("[joinBattle] " + player + ": reached maximum: "
                    + maxPlayers + ". Waiting empty slot");
            currentPlayers++;
            System.out.println("[joinBattle] slot available, joined: " + currentPlayers + " of " + maxPlayers);
        }
    }

    void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notifyAll();
            System.out.println("[leaveBattle] " + player + " disconnected!");
        }
    }
}
