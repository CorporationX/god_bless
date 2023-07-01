package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Boss {
    private int maxPlayer;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers < maxPlayer) {
                currentPlayers++;
                System.out.println(player.getName() + " присоеденился к боссу");
            } else {
                System.out.println("Места нет");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Появилось место");
            }
        }
    }

    public synchronized void finishBattle() {
        currentPlayers--;
        this.notify();
    }
}
