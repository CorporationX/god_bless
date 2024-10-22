package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
            while (currentPlayers >= maxPlayers) {
                System.out.println("Извини игрок " + player.getName() + " все слоты заняты");
                wait();
            }
            currentPlayers++;
            System.out.println("Игрок " + player.getName() + " присоединился к сражению");
    }

    public synchronized void finishedFight(Player player) {
            currentPlayers--;
            System.out.println("игрок " + player.getName() + " завершил сражение");
            System.out.println("всего игроков сейчас сражается: " + currentPlayers);
            notify();
    }
}
