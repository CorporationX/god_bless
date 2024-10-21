package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                System.out.println("Извини игрок " + player.getName() + " все слоты заняты");
                lock.wait();
            }
            currentPlayers++;
            System.out.println("Игрок " + player.getName() + " присоединился к сражению");
        }
    }

    public void finishedFight(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println("игрок " + player.getName() + " завершил сражение");
            System.out.println("всего игроков сейчас сражается: " + currentPlayers);
            lock.notify();
        }
    }
}
