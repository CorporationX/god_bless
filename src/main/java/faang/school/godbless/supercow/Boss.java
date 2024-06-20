package faang.school.godbless.supercow;

public class Boss {
    private String lock = "LOCK";
    private static final int MAX_PLAYERS = 3;
    private int currentPlayers = 0;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers == MAX_PLAYERS) {
                lock.wait();
            }
            currentPlayers++;
            System.out.println("Player " + player.getName() + " joined battle");
        }
    }

    public void finishBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
            System.out.println("Player " + player.getName() + " finished battle");
        }
    }
}
