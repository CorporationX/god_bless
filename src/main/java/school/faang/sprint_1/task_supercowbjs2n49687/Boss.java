package school.faang.sprint_1.task_supercowbjs2n49687;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                System.out.printf("+ %s has joined battle\n", player.getName());
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
