package faang.school.godbless.sync.supercow;

public class Boss {

    private final Object lock = new Object();

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                System.out.println("The battlefield is full. Please wait.");
                lock.wait();
            }
            currentPlayers++;
            System.out.printf("Great, %s! The battle begins!%n", player.name());
        }
    }

    public void exitBattle(Player player) {
        synchronized (lock) {
            System.out.printf("Good, %s! Your part is done.%n", player.name());
            currentPlayers--;
            lock.notify();
        }
    }
}
