package BJS2_12564;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class  Boss {
    private final int maxPlayers;
    private int currentPlayer = 0;
    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            while (currentPlayer >= maxPlayers) {
                player.wait();
            }
            currentPlayer++;
            System.out.printf("%s joined the game. Current players: %d \n", player.name(), currentPlayer);
        }
    }
    public void leaveBattle(Player player) {
        synchronized (this) {
            currentPlayer--;
            System.out.printf("%s leave the game. Current players: %d \n", player.name(), currentPlayer);
            notifyAll();
        }
    }
}