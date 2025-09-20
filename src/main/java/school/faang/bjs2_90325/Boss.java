package school.faang.bjs2_90325;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                System.out.printf("%s присоединился к битве. Игроков: %d/%d%n",
                        player.getName(), currentPlayers, maxPlayers);
            } else if (currentPlayers == maxPlayers) {
                lock.wait();
            }
        }
    }

    public void leaveBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers > 0) {
                currentPlayers--;
                System.out.printf("%s вышел из битвы. Игроков: %d/%d%n",
                        player.getName(), currentPlayers, maxPlayers);
                lock.notify();
            }
        }
    }
}
