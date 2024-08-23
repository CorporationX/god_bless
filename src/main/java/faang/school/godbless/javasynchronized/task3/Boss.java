package faang.school.godbless.javasynchronized.task3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public void joinBattle(Player player) throws InterruptedException {
            synchronized (this) {
                if (maxPlayers - currentPlayers <= 0) {
                    System.out.println("Игрок " + player.getName() + " ожидает присоединения");
                    this.wait();
                }
                currentPlayers++;
                System.out.println("Игрок " + player.getName() + " присоединился к битве с боссом");
            }
            Thread.sleep(5000L);
            endBattle(player);
    }

    public synchronized void endBattle(Player player) {
            System.out.println("Игрок " + player.getName() + " завершил сражение");
            currentPlayers--;
            this.notify();
    }
}