package school.faang.BJS2_61513;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers; //5
    private int currentPlayers = 0;

    private synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers == maxPlayers) {
            this.wait();
        }
        currentPlayers++;
    }

    private synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
        }
        this.notify();
    }
}
