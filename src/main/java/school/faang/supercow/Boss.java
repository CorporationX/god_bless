package school.faang.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers = 6;
    private int currentPlayer = 0;

    public synchronized void  joinBattle(Player player) {
        while (true) {
            if (currentPlayer <= maxPlayers) {
                currentPlayer++;
                break;
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayer--;
        this.notifyAll();
    }
}
