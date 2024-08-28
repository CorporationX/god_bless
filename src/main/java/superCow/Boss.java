package superCow;

import lombok.Getter;

@Getter
public class Boss {
    private final int MAX_PLAYERS = 10;
    private int currentPlayers;
    private Object lock = new Object();

    public Boss(int currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            boolean b = false;
            if (currentPlayers < MAX_PLAYERS) {
                currentPlayers++;
                System.out.println("Сражение началось игроком " + player.getName());
                b = true;
            }
            if (currentPlayers == MAX_PLAYERS) {
                lock.notifyAll();
            }
            if (currentPlayers >= MAX_PLAYERS) {
                currentPlayers--;
            }
        }


    }
}
