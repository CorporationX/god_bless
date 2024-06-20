package faang.school.godbless.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Thread was interrupted " + e.getMessage());
                }
            }

            currentPlayers++;
            System.out.println(player.getName() + " joined the battle");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " left the battle");

            lock.notify();
        }
    }
}
