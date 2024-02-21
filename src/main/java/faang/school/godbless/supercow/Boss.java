package faang.school.godbless.supercow;

public class Boss {

    private int currentPlayers;
    private final int MAX_PLAYERS = 10;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers == MAX_PLAYERS) {
            try {
                System.out.println(player.getName() + " is waiting for space...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle");
    }

    public synchronized void endBattle() {
        currentPlayers--;
        System.out.println("Player completed battle");
        notifyAll();
    }
}
