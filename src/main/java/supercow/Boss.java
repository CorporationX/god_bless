package supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            try {
                while (currentPlayers == maxPlayers) {
                    System.out.println("Сейчас с боссом сражается игроков: " + currentPlayers);
                    System.out.println("Все слоты заняты. Ждем...");
                    lock.wait();
                }
                currentPlayers++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        processBattle(player);
    }

    private void processBattle(Player player) {
        player.battle();
        synchronized (lock) {
            currentPlayers--;
            lock.notifyAll();
        }
    }
}
