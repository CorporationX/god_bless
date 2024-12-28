package school.faang.task_bjs249691;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Boss {
    private final int maxPlayers;
    @Setter
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Ошибка в ожидании босса: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению с боссом!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул сражение с боссом.");
        notify();
    }
}
