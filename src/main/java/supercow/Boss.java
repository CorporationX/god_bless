package supercow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private static final int MAX_PLAYERS = 20;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < MAX_PLAYERS) {
            currentPlayers++;
            System.out.println(player.getName() + " Присоединился к игре!");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        endBattle(player);
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        notify();
        System.out.println(player.getName() + " Покинул игру");
    }
}
