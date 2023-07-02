package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers == maxPlayers) {
            wait();
            System.out.println(player.getName() + " waiting");

        }

        currentPlayers++;
        System.out.println(player.getName() + " joined the battle.");
    }

    public synchronized void endBattle() {
        currentPlayers--;
        System.out.println(" One hero end the battle.");
        notify();
    }
}
