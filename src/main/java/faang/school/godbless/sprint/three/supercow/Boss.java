package faang.school.godbless.sprint.three.supercow;

public class Boss {
    private final int maxPlayers = Constants.MAX_PLAYERS;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (maxPlayers <= currentPlayers) {
                try {
                    System.out.printf("Player %s waiting the battle%n", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf("Player %s join the battle%n", player.getName());
            currentPlayers++;
        }
    }

    public void finishBattle(Player player) {
        synchronized (lock) {
            System.out.printf("Player %s finish the battle%n", player.getName());
            currentPlayers--;
            lock.notify();
        }
    }

}
