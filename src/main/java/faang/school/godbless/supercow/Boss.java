package faang.school.godbless.supercow;

public class Boss {
    private final int MAX_PLAYERS;
    private Integer currentPlayers;

    public Boss(int MAX_PLAYERS, int currentPlayers) {
        this.MAX_PLAYERS = MAX_PLAYERS;
        this.currentPlayers = currentPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers == MAX_PLAYERS) {
            System.out.println(player.getName() + " is waiting for available slots");
            this.wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle");
        Thread.sleep(3000);
    }

    public synchronized void endBattle() {
        currentPlayers--;
        currentPlayers.notifyAll();
    }
}
